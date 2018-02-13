package br.harlan.instagramclone.singleton

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseSingleton {

    private lateinit var databaseReference: DatabaseReference

    fun getInstance(): DatabaseReference {
        if (databaseReference == null)
            databaseReference = FirebaseDatabase.getInstance().getReference()
        return databaseReference
    }
}