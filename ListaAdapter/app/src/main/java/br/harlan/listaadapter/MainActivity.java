package br.harlan.listaadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pessoa> lista;
    ArrayAdapter<Pessoa> adaptadorLista;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        lista=new ArrayList<Pessoa>();
        preencherArrayList();
        adaptadorLista=new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adaptadorLista);
    }

    public void preencherArrayList(){
        Pessoa pessoa=new Pessoa("Harlan","123");
        lista.add(pessoa);
        pessoa.nome="Vanessa";
        pessoa.cpf="234";
        lista.add(pessoa);
        pessoa.nome="vinicius";
        pessoa.cpf="345";
        lista.add(pessoa);
    }
}