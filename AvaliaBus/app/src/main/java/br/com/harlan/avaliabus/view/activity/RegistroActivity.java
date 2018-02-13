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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import br.com.harlan.avaliabus.R;
import br.com.harlan.avaliabus.database.FirebaseSingleton;
import br.com.harlan.avaliabus.model.UsuarioModel;

public class RegistroActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtRepetiSenha;
    private TextView tvLogin;
    private Button btnRegistro;
    private UsuarioModel usuario;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();
        inicializarComponentes();
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoRegistro();
            }
        });
    }

    private void novoRegistro() {
        usuario = new UsuarioModel();
        usuario.setNome(edtNome.getText().toString());
        usuario.setEmail(edtEmail.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());
        if(!edtSenha.getText().toString().equals(edtRepetiSenha.getText().toString()))
            Toast.makeText(RegistroActivity.this, "As senhas não conferem!", Toast.LENGTH_LONG).show();
        if(!edtEmail.getText().toString().isEmpty() && !edtSenha.getText().toString().isEmpty() && !edtNome.getText().toString().isEmpty())
            //new UsuarioBusiness().cadastrarUsuario(usuario); FALTA IMPLEMENTAR
            cadastrarUsuario();
        else
            Toast.makeText(RegistroActivity.this, "Um ou mais campos estão vazios", Toast.LENGTH_LONG).show();
    }

    private void cadastrarUsuario() {
        firebaseAuth = FirebaseSingleton.getFirebaseAuth();
        firebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
        .addOnCompleteListener(RegistroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegistroActivity.this, "Usuário cadastrado com sucesso.", Toast.LENGTH_LONG).show();
                    usuario.setUid(task.getResult().getUser().getUid());
                    usuario.salvarUsuarioFirebase();
                    firebaseAuth.signOut();
                    finish();
                }
                else{
                    String mensagemErro;
                    try{
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        mensagemErro = "Digite uma senha mais forte, contendo mais caracteres e com letras e números.";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        mensagemErro = "O e-mail digitado é inválido, digite um novo e-mail.";
                    } catch (FirebaseAuthUserCollisionException e) {
                        mensagemErro = "Esse e-mail já está em uso no App.";
                    } catch (Exception e) {
                        mensagemErro = "Erro ao cadastrar usuário.";
                        e.printStackTrace();
                    }

                    Toast.makeText(RegistroActivity.this, mensagemErro, Toast.LENGTH_LONG ).show();
                }
            }
        });
    }

    private void inicializarComponentes() {
        edtNome = (EditText) findViewById(R.id.edtNomeRegistro);
        edtEmail = (EditText) findViewById(R.id.edtEmailRegistro);
        edtSenha = (EditText) findViewById(R.id.edtSenhaRegistro);
        edtRepetiSenha = (EditText) findViewById(R.id.edtRepetiSenhaRegistro);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        btnRegistro = (Button) findViewById(R.id.btnRegistrar);
    }
}