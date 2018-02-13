package harlan.exemplocadastro.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import harlan.exemplocadastro.bll.PessoaBLL;
import harlan.exemplocadastro.dto.PessoaDTO;
import harlan.exemplocadastro.dao.DadosPessoas;
import harlan.exemplocadastro.R;

public class Cadastrar extends Activity {
    private EditText edtNome;
    private EditText edtCPF;
    private Button btnCadastrar;
    private Button btnCancelar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        setEdtNome((EditText)findViewById(R.id.edtNome));
        setEdtCPF((EditText)findViewById(R.id.edtCPF));
        setBtnCadastrar((Button)findViewById(R.id.btnCadastrar));
        setBtnCancelar((Button)findViewById(R.id.btnCancelar));

        getBtnCadastrar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    boolean aux;
                    aux = PessoaBLL.validarCpf(getEdtCPF().getText().toString());
                    if (aux == true) {
                        armazenarDados();
                        finish();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        getBtnCancelar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityMain = new Intent(Cadastrar.this, MainActivity.class);
                startActivity(activityMain);
            }
        });
    }
    public void armazenarDados(){
        DadosPessoas.armazenarDados(new PessoaDTO(getEdtNome().getText().toString(), getEdtCPF().getText().toString()));
        Toast.makeText(getApplicationContext(), "Dados cadastrados com sucesso.", Toast.LENGTH_LONG).show();
        limparDados();
    }
    public void limparDados(){
        getEdtCPF().setText(null);
        getEdtNome().setText(null);
    }

    public EditText getEdtNome() {
        return edtNome;
    }
    public void setEdtNome(EditText edtNome) {
        this.edtNome = edtNome;
    }
    public EditText getEdtCPF() {
        return edtCPF;
    }
    public void setEdtCPF(EditText edtCPF) {
        this.edtCPF = edtCPF;
    }
    public Button getBtnCadastrar() {
        return btnCadastrar;
    }
    public void setBtnCadastrar(Button btnCadastrar) {
        this.btnCadastrar = btnCadastrar;
    }
    public Button getBtnCancelar() {
        return btnCancelar;
    }
    public void setBtnCancelar(Button btnCancelar) {
        this.btnCancelar = btnCancelar;
    }
}