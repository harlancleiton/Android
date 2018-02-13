package harlan.biblioteca.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import harlan.biblioteca.R;

public class MainActivity extends Activity {
    Button btnCadastrar, btnConsultar, btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCadastrar=(Button)findViewById(R.id.btnCadastrar);
        btnConsultar=(Button)findViewById(R.id.btnConsultar);
        btnEditar=(Button)findViewById(R.id.btnEditar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityCadastrar=new Intent(MainActivity.this, Cadastrar.class);
                startActivity(activityCadastrar);
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent activityConsultar=new Intent(MainActivity.this, Consultar.class);
                startActivity(activityConsultar);
            }
        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityEditar=new Intent(MainActivity.this, Editar.class);
                startActivity(activityEditar);
            }
        });
    }
}