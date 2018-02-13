package harlan.primeiroapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner listaSexo;
    String[] itensSpinner;
    ArrayAdapter<String> adapter;
    EditText edtNome, edtIdade;
    Button btnOk;
    String nome, sexo;
    int idade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaSexo=(Spinner)findViewById(R.id.spinnerSexo);
        btnOk=(Button)findViewById(R.id.btnOk);
        itensSpinner=new String[]{"Masculino", "Feminino"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itensSpinner);
        listaSexo.setAdapter(adapter);
        edtNome=(EditText)findViewById(R.id.edtNome);
        edtIdade=(EditText)findViewById(R.id.edtIdade);
        listaSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                sexo = parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Alerta();
            }
        });
    }
    public void Alerta() {
        AlertDialog.Builder alertaDialogBuilder=new AlertDialog.Builder(this);
        AlertDialog alertaDialog;
        alertaDialogBuilder.setTitle("Sobre você...");
        nome = edtNome.getText().toString();
        idade = Integer.parseInt(edtIdade.getText().toString());
        alertaDialogBuilder.setMessage("Seu nome é " + nome + ", " + idade + " anos, do sexo " + sexo + ".");
        alertaDialogBuilder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                edtIdade.setText(null);
                edtNome.setText(null);
            }
        });
        alertaDialog=alertaDialogBuilder.create();
        alertaDialog.show();
    }
}