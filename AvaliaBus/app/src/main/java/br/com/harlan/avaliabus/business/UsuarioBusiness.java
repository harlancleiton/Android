package br.com.harlan.avaliabus.business;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

import br.com.harlan.avaliabus.database.FirebaseSingleton;
import br.com.harlan.avaliabus.database.UsuarioDatabase;
import br.com.harlan.avaliabus.model.UsuarioModel;
import br.com.harlan.avaliabus.view.activity.LoginActivity;
import br.com.harlan.avaliabus.view.activity.MainActivity;

public class UsuarioBusiness {

    public void deslogarUsuario() {
        new UsuarioDatabase().deslogarUsuario();
    }

    public void cadastrarUsuario(UsuarioModel usuario) {}

    public void validarLogin(UsuarioModel usuario) throws Exception{

    }
}
