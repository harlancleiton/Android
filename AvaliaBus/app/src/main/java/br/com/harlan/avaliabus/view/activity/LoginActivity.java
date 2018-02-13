package br.com.harlan.avaliabus.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

import br.com.harlan.avaliabus.R;
import br.com.harlan.avaliabus.business.UsuarioBusiness;
import br.com.harlan.avaliabus.database.FirebaseSingleton;
import br.com.harlan.avaliabus.model.UsuarioModel;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private TextView tvRegistro;
    private TextView tvEsqueciSenha;
    private Button btnLogin;
    private UsuarioModel usuario;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        inicializarComponentes();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoLogin();
            }
        });
        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
        tvEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, EsqueciSenhaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void novoLogin(){
        usuario = new UsuarioModel();
        usuario.setEmail(edtEmail.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());
        if(!edtEmail.getText().toString().isEmpty() && !edtSenha.getText().toString().isEmpty())
            validarLogin();
        else
            Toast.makeText(LoginActivity.this, "Um ou mais campos estão vazios", Toast.LENGTH_LONG).show();
    }

    private void validarLogin() {
        firebaseAuth = FirebaseSingleton.getFirebaseAuth();
        firebaseAuth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Usuário e senha incorretos ou usuário não cadastrado.", Toast.LENGTH_LONG).show();
                    //TRY/CATCH AQUI:
                }
            }
        });
    }

    private void inicializarComponentes() {
        edtEmail = (EditText) findViewById(R.id.edtEmailLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenhaLogin);
        tvRegistro = (TextView) findViewById(R.id.tvRegistro);
        tvEsqueciSenha = (TextView) findViewById(R.id.tvEsqueciSenha);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }
}
