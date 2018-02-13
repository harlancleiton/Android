package br.com.harlan.asynctask.business;

import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import br.com.harlan.asynctask.database.UsuarioDatabase;
import br.com.harlan.asynctask.model.UsuarioModel;

public class UsuarioBusiness extends AsyncTask<UsuarioModel, Integer, Task<AuthResult>> implements TaskInterface {

    private Context context;
    private TaskInterface taskInterface;
    private Task<AuthResult> authResultTask = null;

    public UsuarioBusiness(Context context, TaskInterface taskInterface) {
        this.context = context;
        this.taskInterface = taskInterface;
    }

    private boolean validarDados(UsuarioModel usuario) {
        return true;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Task<AuthResult> doInBackground(UsuarioModel... usuarioModels) {
        if (validarDados(usuarioModels[0])) {
            UsuarioDatabase usuarioDatabase = new UsuarioDatabase(this);
            usuarioDatabase.execute(usuarioModels[0]);
        }

        return authResultTask;
    }

    @Override
    protected void onPostExecute(Task<AuthResult> authResultTask) {
        super.onPostExecute(authResultTask);
        taskInterface.retornarTask(authResultTask);
    }

    @Override
    public void retornarTask(Task<AuthResult> task) {
        authResultTask = task;
    }
}