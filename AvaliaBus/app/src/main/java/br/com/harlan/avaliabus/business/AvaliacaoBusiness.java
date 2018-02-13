package br.com.harlan.avaliabus.business;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.harlan.avaliabus.database.FirebaseSingleton;
import br.com.harlan.avaliabus.model.AvaliacaoModel;

public class AvaliacaoBusiness {
    public ArrayList<AvaliacaoModel> getAvaliacoes(){
        final ArrayList<AvaliacaoModel> avaliacaoModels = new ArrayList<AvaliacaoModel>();
        FirebaseAuth myUser = FirebaseSingleton.getFirebaseAuth();
        DatabaseReference myRef = FirebaseSingleton.getDatabaseReference().child("avaliacoes").child(myUser.getCurrentUser().getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dadosConsulta: dataSnapshot.getChildren()){
                    AvaliacaoModel aux = dadosConsulta.getValue(AvaliacaoModel.class);
                    avaliacaoModels.add(aux);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return avaliacaoModels;
    }

    /*public ArrayList<AvaliacaoModel> getAvaliacoes(){
        ArrayList<AvaliacaoModel> avaliacaoModels = new ArrayList<>();
        AvaliacaoModel avaliacaoModel1 = new AvaliacaoModel();
        AvaliacaoModel avaliacaoModel2 = new AvaliacaoModel();
        AvaliacaoModel avaliacaoModel3 = new AvaliacaoModel();
        avaliacaoModel1.setDataHora(DataHoraAtual.getDataHora());
        avaliacaoModel1.setNumeroOnibus(30763);
        avaliacaoModel1.setNumeroLinha(1616);

        avaliacaoModel2.setDataHora(DataHoraAtual.getDataHora());
        avaliacaoModel2.setNumeroOnibus(39135);
        avaliacaoModel2.setNumeroLinha(1614);

        avaliacaoModel3.setDataHora(DataHoraAtual.getDataHora());
        avaliacaoModel3.setNumeroOnibus(10831);
        avaliacaoModel3.setNumeroLinha(1228);

        avaliacaoModels.add(avaliacaoModel1);
        avaliacaoModels.add(avaliacaoModel2);
        avaliacaoModels.add(avaliacaoModel3);

        return avaliacaoModels;
    }*/
}
