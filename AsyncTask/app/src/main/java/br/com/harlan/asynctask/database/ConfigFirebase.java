package br.com.harlan.asynctask.database;

import br.com.harlan.asynctask.database.singleton.FirebaseSingleton;

public interface ConfigFirebase {
    String ID_USUARIO = FirebaseSingleton.getFirebaseAuth().getCurrentUser().getUid();
    String CHILD_USUARIO = "usuarios";
    String CHILD_KEY = FirebaseSingleton.getDatabaseReference().push().getKey();
}