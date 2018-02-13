package harlan.exemplocadastro.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import harlan.exemplocadastro.R;
import harlan.exemplocadastro.dao.DadosPessoas;

public class Listar extends Activity{
    private TextView txtListar;
    Button btnVoltar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        setTxtListar((TextView) findViewById(R.id.txtListar));
        btnVoltar=(Button)findViewById(R.id.btnVoltar);

        getTxtListar().setText(DadosPessoas.listarDados());

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityMain=new Intent(Listar.this, MainActivity.class);
                startActivity(activityMain);
            }
        });
    }

    public TextView getTxtListar() {
        return txtListar;
    }
    public void setTxtListar(TextView txtListar) {
        this.txtListar = txtListar;
    }
}