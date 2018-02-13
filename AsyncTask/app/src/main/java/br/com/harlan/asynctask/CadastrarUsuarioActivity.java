package br.com.harlan.asynctask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import br.com.harlan.asynctask.business.TaskInterface;
import br.com.harlan.asynctask.business.UsuarioBusiness;
import br.com.harlan.asynctask.constantes.ExcecaoFirebaseAuth;
import br.com.harlan.asynctask.model.UsuarioModel;

public class CadastrarUsuarioActivity extends Activity implements ExcecaoFirebaseAuth, TaskInterface {

    EditText edtUsuario;
    EditText edtSenha;
    EditText edtEmail;
    Button btnSalvar;
    Task<AuthResult> authResultTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        inicializarComponentes();
        adicionarEventos();
    }

    private void cadastrarUsuario() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setUsuario(edtUsuario.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());
        usuario.setEmail(edtEmail.getText().toString());

        UsuarioBusiness usuarioBusiness = new UsuarioBusiness(this, this);
        usuarioBusiness.execute(usuario);
    }

    private void adicionarEventos() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarUsuario();
            }
        });
    }

    private void inicializarComponentes() {
        edtUsuario = (EditText) findViewById(R.id.edit_usuario);
        edtSenha = (EditText) findViewById(R.id.edit_senha);
        edtEmail = (EditText) findViewById(R.id.edit_email);
        btnSalvar = (Button) findViewById(R.id.btn_salvar);
    }

    @Override
    public void retornarTask(Task<AuthResult> task) {
        authResultTask = task;

        String mensagem = "";

        if (authResultTask != null)
            if (authResultTask.isSuccessful()) {
                mensagem = FIREBASE_AUTH_CREATE_USER_SUCCESS;
            } else {
                try {
                    throw authResultTask.getException();
                } catch (FirebaseAuthWeakPasswordException e) {
                    mensagem = FIREBASE_AUTH_WEAK_PASSWORD_EXCEPTION;
                    e.printStackTrace();
                } catch (FirebaseAuthInvalidCredentialsException e) {
                    mensagem = FIREBASE_AUTH_INVALID_CREDENTIALS_EXCEPTION;
                    e.printStackTrace();
                } catch (FirebaseAuthUserCollisionException e) {
                    mensagem = FIREBASE_AUTH_USER_COLLISION_EXCEPTION;
                    e.printStackTrace();
                } catch (Exception e) {
                    mensagem = FIREBASE_AUTH_EXCEPTION;
                    e.printStackTrace();
                }
            }
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
