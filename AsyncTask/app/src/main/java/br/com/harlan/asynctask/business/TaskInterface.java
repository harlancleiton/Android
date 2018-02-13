package br.com.harlan.asynctask.business;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * Created by Harlan on 21/09/2017.
 */

public interface TaskInterface {
    public void retornarTask(Task<AuthResult> task);
}
