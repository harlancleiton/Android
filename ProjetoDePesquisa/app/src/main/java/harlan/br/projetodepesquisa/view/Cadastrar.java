package harlan.br.projetodepesquisa.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import harlan.br.projetodepesquisa.R;

public class Cadastrar extends Activity{
    private EditText edtTitulo;
    private EditText edtNoticia;
    private Button btnConfirmar;
    private Button btnCancelar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        setBtnCancelar((Button)findViewById(R.id.btnCancelar));
        setBtnConfirmar((Button)findViewById(R.id.btnConfirmar));
        setEdtNoticia((EditText)findViewById(R.id.edtNoticia));
        setEdtTitulo((EditText)findViewById(R.id.edtTitulo));

        getBtnCancelar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityMain=new Intent(Cadastrar.this,MainActivity.class);
                startActivity(activityMain);
            }
        });

        getBtnConfirmar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public EditText getEdtTitulo() {
        return edtTitulo;
    }
    public void setEdtTitulo(EditText edtTitulo) {
        this.edtTitulo = edtTitulo;
    }
    public EditText getEdtNoticia() {
        return edtNoticia;
    }
    public void setEdtNoticia(EditText edtNoticia) {
        this.edtNoticia = edtNoticia;
    }
    public Button getBtnConfirmar() {
        return btnConfirmar;
    }
    public void setBtnConfirmar(Button btnConfirmar) {
        this.btnConfirmar = btnConfirmar;
    }
    public Button getBtnCancelar() {
        return btnCancelar;
    }
    public void setBtnCancelar(Button btnCancelar) {
        this.btnCancelar = btnCancelar;
    }
}