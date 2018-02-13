package br.harlan.appav2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends Activity {

    EditText edtNumOnibus, edtInfoComplementares;
    RatingBar rtbConservacao, rtbLimpeza, rtbDirecao;
    Button btnAnexar, btnEnviar;
    AlertDialog alertaEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumOnibus=(EditText)findViewById(R.id.edtNumeroOnibus);
        edtInfoComplementares=(EditText)findViewById(R.id.edtInfoComplementares);
        rtbConservacao=(RatingBar)findViewById(R.id.ratingBarConservacao);
        rtbLimpeza=(RatingBar)findViewById(R.id.ratingBarLimpeza);
        rtbDirecao=(RatingBar)findViewById(R.id.ratingBarMotorista);
        btnAnexar=(Button)findViewById(R.id.btnAnexar);
        btnEnviar=(Button)findViewById(R.id.btnEnviar);
        alertaEnviar=new AlertDialog.Builder(this).create();

        btnAnexar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AlertDialog alertaEnviar=new AlertDialog.Builder(this).create();
                alertaEnviar.setTitle("Confirmação...");
                alertaEnviar.setMessage("Você confirma o envio das informações?");
                alertaEnviar.setButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        enviarDados();
                    }
                });
                alertaEnviar.show();
            }
        });
    }

    public void enviarDados(){

    }
}