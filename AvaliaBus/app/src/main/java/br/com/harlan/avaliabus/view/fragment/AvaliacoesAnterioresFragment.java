package br.com.harlan.avaliabus.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.harlan.avaliabus.R;
import br.com.harlan.avaliabus.adapter.AvaliacaoArrayAdapter;
import br.com.harlan.avaliabus.business.AvaliacaoBusiness;
import br.com.harlan.avaliabus.database.FirebaseSingleton;
import br.com.harlan.avaliabus.model.AvaliacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvaliacoesAnterioresFragment extends Fragment {

    ListView listView;
    ArrayList<AvaliacaoModel> avaliacaoModels;
    ArrayAdapter avaliacaoAdapter;

    public AvaliacoesAnterioresFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Histórico de avaliações");
        View view = inflater.inflate(R.layout.fragment_avaliacoes_anteriores, container, false);
        listView = (ListView)view.findViewById(R.id.lv_avaliacoes_anteriores);
        avaliacaoModels = getAvaliacoes();
        avaliacaoAdapter = new AvaliacaoArrayAdapter(getContext(), avaliacaoModels);
        //inicializarComponentes(view);

        listView.setAdapter(avaliacaoAdapter);

        return view;
    }

    private ArrayList<AvaliacaoModel> getAvaliacoes(){
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
                avaliacaoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return avaliacaoModels;
    }

    private void inicializarComponentes(View view) {
        listView = (ListView)view.findViewById(R.id.lv_avaliacoes_anteriores);
        avaliacaoModels = new AvaliacaoBusiness().getAvaliacoes();
        avaliacaoAdapter = new AvaliacaoArrayAdapter(view.getContext(), avaliacaoModels);
    }

}