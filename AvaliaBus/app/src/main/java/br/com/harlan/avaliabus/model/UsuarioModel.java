package br.com.harlan.avaliabus.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.Date;

import br.com.harlan.avaliabus.database.FirebaseSingleton;

public class UsuarioModel {
    private String uid;

    private String nome;
    private String email;
    private String senha;

    public UsuarioModel(){}

    public void salvarUsuarioFirebase() {
        DatabaseReference databaseReference = FirebaseSingleton.getDatabaseReference();
        databaseReference.child("usuarios").child(getUid()).setValue(this);
    }

    @Exclude
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}