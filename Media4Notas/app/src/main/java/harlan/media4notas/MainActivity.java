package harlan.media4notas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNota1, edtNota2, edtNota3, edtNota4, edtMedia;
    Button btnCalcularMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNota1=(EditText) findViewById(R.id.edtNota1);
        edtNota2=(EditText) findViewById(R.id.edtNota2);
        edtNota3=(EditText) findViewById(R.id.edtNota3);
        edtNota4=(EditText) findViewById(R.id.edtNota4);
        edtMedia=(EditText) findViewById(R.id.edtMedia);
        btnCalcularMedia=(Button) findViewById(R.id.btnCalcularMedia);

        btnCalcularMedia.setOnClickListener(new View.OnClickListener() {
            double nota1, nota2, nota3, nota4,notaMinima=4;
            @Override
            public void onClick(View v) {
                nota1=Double.parseDouble(edtNota1.getText().toString());
                nota2=Double.parseDouble(edtNota2.getText().toString());
                nota3=Double.parseDouble(edtNota3.getText().toString());
                nota4=Double.parseDouble(edtNota4.getText().toString());

                if (nota1<notaMinima || nota2<notaMinima || nota3<notaMinima || nota4<notaMinima){
                    edtMedia.setText("Nota(s) abaixo do valor mínimo (4,0). Aluno reprovado.");
                }
                else{
                    edtMedia.setText("Aluno aprovado, média final: "+calcularMedia(nota1,nota2,nota3,nota4)+".");
                }
            }
        });
    }

    public double calcularMedia(Double nota1, double nota2, double nota3, double nota4){

        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;
    }
}