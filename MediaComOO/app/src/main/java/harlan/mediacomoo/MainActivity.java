package harlan.mediacomoo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.Exception;
import bll.Media;

public class MainActivity extends Activity {

    EditText edtNota1, edtNota2, edtNota3, edtNota4, txtMedia;
    Button btnCalcularMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNota1=(EditText) findViewById(R.id.edtNota1);
        edtNota2=(EditText) findViewById(R.id.edtNota2);
        edtNota3=(EditText) findViewById(R.id.edtNota3);
        edtNota4=(EditText) findViewById(R.id.edtNota4);
        txtMedia=(EditText) findViewById(R.id.txtMedia);
        btnCalcularMedia=(Button) findViewById(R.id.btnCalcularMedia);

        btnCalcularMedia.setOnClickListener(new View.OnClickListener() {
            double nota1, nota2, nota3, nota4,notaMinima=4;
            @Override
            public void onClick(View v) {
                nota1=Double.parseDouble(edtNota1.getText().toString());
                nota2=Double.parseDouble(edtNota2.getText().toString());
                nota3=Double.parseDouble(edtNota3.getText().toString());
                nota4=Double.parseDouble(edtNota4.getText().toString());
                double media;

                try{
                    media= Media.calcularMedia(nota1, nota2, nota3, nota4);
                    txtMedia.setText("Aluno aprovado, média final: "+media+".");
                }
                catch (Exception e){
                    txtMedia.setText(e.getMessage());
                }
            }
        });
    }
}