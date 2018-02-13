package br.com.harlan.avaliabus.view.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import br.com.harlan.avaliabus.R;
import br.com.harlan.avaliabus.business.UsarCamera;
import br.com.harlan.avaliabus.business.UsarStorageFirebase;
import br.com.harlan.avaliabus.database.FirebaseSingleton;
import br.com.harlan.avaliabus.helper.DataHoraAtual;
import br.com.harlan.avaliabus.model.AvaliacaoModel;

public class AvaliacaoFragment extends Fragment implements UsarCamera, UsarStorageFirebase {

    //EditText
    private EditText edtNumeroOnibus;
    private EditText edtNumeroLinha;
    private EditText edtObservacoes;
    //Button
    private Button btnEnviar;
    //ImageView
    ImageView ivAbriCamera;
    //Ratingbar
    private RatingBar rbOnibus;
    private RatingBar rbMotorista;
    private RatingBar rbSeguranca;
    private RatingBar rbLinha;
    //Checkbox
    private CheckBox cbOnibusSujo;
    private CheckBox cbJanelaDanificada;
    private CheckBox cbAssentoQuebrado;
    private CheckBox cbLampadaNaoAcende;
    private CheckBox cbMotoristaNaoParou;
    private CheckBox cbMotoristaCelular;
    private CheckBox cbMotoristaFreouBruscamente;
    private CheckBox cbMotoristaVelocidade;
    private CheckBox cbOnibusAssaltado;
    private CheckBox cbAtosVandalismo;
    private CheckBox cbBrigasOnibus;
    private CheckBox cbOnibusQuebrou;
    private CheckBox cbPercursoLongo;
    private CheckBox cbAreasAriscadas;
    private CheckBox cbOnibusLinhaAssaltados;
    private AvaliacaoModel avaliacao;
    //Foto
    private File foto;
    private Uri uriFoto;
    private ImageView testImg;
    //StorageFirebase
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    public AvaliacaoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_avaliacao, container, false);
        getActivity().setTitle("Avalie sua viagem");
        inicializarComponentes(view);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarAvaliacao();
            }
        });
        ivAbriCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturarFoto();
            }
        });
        return view;
    }

    public void capturarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            try {
                foto = criarFoto();
                Toast.makeText(getActivity(), "Foto criada", Toast.LENGTH_LONG);
            } catch (IOException e) {
                Toast.makeText(getActivity(), "Ops, algo deu errado ao tirar a foto:\n" + e.getMessage(), Toast.LENGTH_LONG);
            }
            if (foto != null) {
                uriFoto = FileProvider.getUriForFile(getActivity().getBaseContext(),
                        getActivity().getBaseContext().getApplicationContext().getPackageName() + ".provider", foto);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null)
                    startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        }

    }

    private File criarFoto() throws IOException {
        String dataHora = DataHoraAtual.getDataHora();
        String nomeFoto = "AvaliaBus_" + FirebaseSingleton.getFirebaseAuth().getCurrentUser().getUid() + dataHora;
        String formatoFoto = ".jpg";
        File caminhoPasta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        foto = new File(caminhoPasta.getPath() + File.separator + nomeFoto + formatoFoto);
        return foto;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == getActivity().RESULT_OK) {
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(foto));
            getActivity().sendBroadcast(intent);
            Toast.makeText(getActivity(), "Teste onActivityResult", Toast.LENGTH_LONG).show();
            exibirImagem();
        }
    }

    private void exibirImagem() {
        int targetW = testImg.getWidth();
        int targetH = testImg.getHeight();
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(foto.getAbsolutePath(), bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        Bitmap bitmap = BitmapFactory.decodeFile(foto.getAbsolutePath(), bmOptions);
        testImg.setImageBitmap(bitmap);
    }

    private void enviarAvaliacao() {
        carregarDadosAvaliacao();
        carregarImagensAvaliacao();
        Toast.makeText(getActivity(), "Teste da chave" + avaliacao.getId(), Toast.LENGTH_LONG).show();
        avaliacao.salvarAvaliacaoFirebase();
    }

    private void carregarImagensAvaliacao() {
        storageReference = FirebaseSingleton.getFirebaseStorage().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference(FIREBASE_DATABASE_PATH);
    }

    private void carregarDadosAvaliacao() {
        avaliacao = new AvaliacaoModel();
        avaliacao.setId(FirebaseSingleton.getDatabaseReference().push().getKey());
        avaliacao.setIdUsuario(FirebaseSingleton.getFirebaseAuth().getCurrentUser().getUid());
        avaliacao.setDataHora(DataHoraAtual.getDataHora());
        avaliacao.setObservacoes(edtObservacoes.getText().toString());
        avaliacao.setNumeroOnibus(Integer.parseInt(edtNumeroOnibus.getText().toString()));
        avaliacao.setNumeroLinha(Integer.parseInt(edtNumeroLinha.getText().toString()));
        avaliacao.setNotaOnibus(rbOnibus.getRating());
        avaliacao.setNotaMotorista(rbMotorista.getRating());
        avaliacao.setNotaSeguranca(rbSeguranca.getRating());
        avaliacao.setNotaLinha(rbLinha.getRating());
        avaliacao.setOnibusSujo(cbOnibusSujo.isChecked());
        avaliacao.setJanelaDanificada(cbJanelaDanificada.isChecked());
        avaliacao.setAssentoQuebrado(cbAssentoQuebrado.isChecked());
        avaliacao.setLampadaNaoAcende(cbLampadaNaoAcende.isChecked());
        avaliacao.setMotoristaNaoParou(cbMotoristaNaoParou.isChecked());
        avaliacao.setMotoristaCelular(cbMotoristaCelular.isChecked());
        avaliacao.setMotoristaFreouBruscamente(cbMotoristaFreouBruscamente.isChecked());
        avaliacao.setMotoristaVelocidade(cbMotoristaVelocidade.isChecked());
        avaliacao.setOnibusAssaltado(cbOnibusAssaltado.isChecked());
        avaliacao.setAtosVandalismo(cbAtosVandalismo.isChecked());
        avaliacao.setBrigasOnibus(cbBrigasOnibus.isChecked());
        avaliacao.setOnibusQuebrou(cbOnibusQuebrou.isChecked());
        avaliacao.setPercursoLongo(cbPercursoLongo.isChecked());
        avaliacao.setAreasAriscadas(cbAreasAriscadas.isChecked());
        avaliacao.setOnibusLinhaAssaltados(cbOnibusLinhaAssaltados.isChecked());
    }

    private void inicializarComponentes(View view) {
        foto = null;
        edtNumeroOnibus = (EditText) view.findViewById(R.id.edtNumeroOnibus);
        edtNumeroLinha = (EditText) view.findViewById(R.id.edtNumeroLinha);
        edtObservacoes = (EditText) view.findViewById(R.id.edtObservacoes);
        btnEnviar = (Button) view.findViewById(R.id.btnEnviar);
        rbOnibus = (RatingBar) view.findViewById(R.id.rbLinhaAvaliar);
        rbMotorista = (RatingBar) view.findViewById(R.id.rbMotoristaAvaliar);
        rbSeguranca = (RatingBar) view.findViewById(R.id.rbSegurancaAvaliar);
        rbLinha = (RatingBar) view.findViewById(R.id.rbLinhaAvaliar);
        cbOnibusSujo = (CheckBox) view.findViewById(R.id.cbOnibusSujo);
        cbJanelaDanificada = (CheckBox) view.findViewById(R.id.cbJanela);
        cbAssentoQuebrado = (CheckBox) view.findViewById(R.id.cbAssentosQuebrados);
        cbLampadaNaoAcende = (CheckBox) view.findViewById(R.id.cbLampadas);
        cbMotoristaNaoParou = (CheckBox) view.findViewById(R.id.cbMotoristaNaoParou);
        cbMotoristaCelular = (CheckBox) view.findViewById(R.id.cbMotoristaCelular);
        cbMotoristaFreouBruscamente = (CheckBox) view.findViewById(R.id.cbMotoristaFreouBruscmente);
        cbMotoristaVelocidade = (CheckBox) view.findViewById(R.id.cbMotoristaVelocidade);
        cbOnibusAssaltado = (CheckBox) view.findViewById(R.id.cbOnibusAssaltado);
        cbAtosVandalismo = (CheckBox) view.findViewById(R.id.cbAtosVandalismo);
        cbBrigasOnibus = (CheckBox) view.findViewById(R.id.cbBrigas);
        cbOnibusQuebrou = (CheckBox) view.findViewById(R.id.cbOnibusQuebrou);
        cbPercursoLongo = (CheckBox) view.findViewById(R.id.cbLinhaDemorada);
        cbAreasAriscadas = (CheckBox) view.findViewById(R.id.cbLinhaAreasArriscadas);
        cbOnibusLinhaAssaltados = (CheckBox) view.findViewById(R.id.cbLinhaAssaltada);
        ivAbriCamera = (ImageView) view.findViewById(R.id.ivAnexo);
        testImg = (ImageView) view.findViewById(R.id.imageView8);
    }
}