package harlan.br.projetodepesquisa.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import harlan.br.projetodepesquisa.R;

public class MainActivity extends Activity {
    private Button btnCadastrar, btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBtnCadastrar((Button)findViewById(R.id.btnCadastrar));
        setBtnListar((Button)findViewById(R.id.btnListar));

        getBtnCadastrar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityCadastrar=new Intent(MainActivity.this, Cadastrar.class);
                startActivity(activityCadastrar);
            }
        });
        getBtnListar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityListar=new Intent(MainActivity.this, Listar.class);
                startActivity(activityListar);
            }
        });
    }

    public Button getBtnCadastrar() {
        return btnCadastrar;
    }
    public void setBtnCadastrar(Button btnCadastrar) {
        this.btnCadastrar = btnCadastrar;
    }
    public Button getBtnListar() {
        return btnListar;
    }
    public void setBtnListar(Button btnListar) {
        this.btnListar = btnListar;
    }
}