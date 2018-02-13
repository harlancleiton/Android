package br.com.harlan.asynctask.database.singleton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseSingleton {
    private static DatabaseReference databaseReference;
    private static FirebaseAuth firebaseAuth;
    private static FirebaseStorage firebaseStorage;
    private static StorageReference storageReference;

    private FirebaseSingleton(){}

    public static StorageReference getStorageReference(){
        if(storageReference==null)
            storageReference=getFirebaseStorage().getReference();
        return storageReference;
    }

    public static FirebaseStorage getFirebaseStorage(){
        if(firebaseStorage==null)
            firebaseStorage=FirebaseStorage.getInstance();
        return firebaseStorage;
    }

    public static FirebaseAuth getFirebaseAuth(){
        if (firebaseAuth==null)
            firebaseAuth=FirebaseAuth.getInstance();
        return firebaseAuth;
    }

    public static DatabaseReference getDatabaseReference(){
        if(databaseReference==null)
            databaseReference= FirebaseDatabase.getInstance().getReference();
        return databaseReference;
    }
}
