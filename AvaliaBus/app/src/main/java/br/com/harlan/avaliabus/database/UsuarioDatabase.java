package br.com.harlan.avaliabus.database;

import com.google.firebase.auth.FirebaseAuth;

import br.com.harlan.avaliabus.model.UsuarioModel;

public class UsuarioDatabase {

    public void deslogarUsuario(){
        FirebaseAuth firebaseAuth = FirebaseSingleton.getFirebaseAuth();
        firebaseAuth.signOut();
    }
}
