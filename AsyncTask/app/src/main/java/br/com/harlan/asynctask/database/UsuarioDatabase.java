package br.com.harlan.asynctask.database;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.harlan.asynctask.business.TaskInterface;
import br.com.harlan.asynctask.database.singleton.FirebaseSingleton;
import br.com.harlan.asynctask.model.UsuarioModel;

public class UsuarioDatabase extends AsyncTask<UsuarioModel, Integer, Task<AuthResult>> implements TaskInterface {

    private Task<AuthResult> authResultTask;
    private TaskInterface taskInterface;

    public UsuarioDatabase(TaskInterface taskInterface) {
        this.taskInterface = taskInterface;
    }

    public void cadastrarUsuario(UsuarioModel usuario) {
        FirebaseAuth mFirebaseAuth = FirebaseSingleton.getFirebaseAuth();
        mFirebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        authResultTask = task;
                    }
                });
    }

    @Override
    protected Task<AuthResult> doInBackground(UsuarioModel... usuarioModels) {
        cadastrarUsuario(usuarioModels[0]);
        if (authResultTask == null) {
            return null;
        } else {
            return authResultTask;
        }
    }

    @Override
    public void retornarTask(Task<AuthResult> task) {
        taskInterface.retornarTask(task);
    }
}