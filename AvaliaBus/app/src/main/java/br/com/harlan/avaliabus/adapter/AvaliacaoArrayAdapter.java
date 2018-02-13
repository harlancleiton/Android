package br.com.harlan.avaliabus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import br.com.harlan.avaliabus.R;
import br.com.harlan.avaliabus.model.AvaliacaoModel;

public class AvaliacaoArrayAdapter extends ArrayAdapter<AvaliacaoModel> {

    private final Context context;
    private final ArrayList<AvaliacaoModel> arrayListAvaliacao;

    public AvaliacaoArrayAdapter(Context context, ArrayList<AvaliacaoModel> arrayListAvaliacao) {
        super(context, R.layout.linha_avaliacao, arrayListAvaliacao);
        this.context = context;
        this.arrayListAvaliacao = arrayListAvaliacao;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_avaliacao,parent,false);

        final TextView tvNumeroOnibus = (TextView)rowView.findViewById(R.id.tv_numero_onibus);
        final TextView tvNumeroLinha = (TextView)rowView.findViewById(R.id.tv_numero_linha);
        RatingBar rbMotorista = (RatingBar)rowView.findViewById(R.id.rb_motorista_visualizar_avaliacao);
        RatingBar rbOnibus = (RatingBar)rowView.findViewById(R.id.rb_onibus_visualizar_avaliacao);
        RatingBar rbSeguranca = (RatingBar)rowView.findViewById(R.id.rb_seguranca_visualizar_avaliacao);
        RatingBar rbLinha = (RatingBar)rowView.findViewById(R.id.rb_linha_visualizar_avaliacao);
        ImageView ivEdit = (ImageView)rowView.findViewById(R.id.ivEdit);
        ImageView ivDelete = (ImageView)rowView.findViewById(R.id.ivDelete);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Teste edit: "+tvNumeroLinha.getText()+" - "+tvNumeroOnibus.getText(), Toast.LENGTH_LONG).show();
            }
        });

        tvNumeroOnibus.setText(Integer.toString(arrayListAvaliacao.get(position).getNumeroOnibus()));
        tvNumeroLinha.setText(Integer.toString(arrayListAvaliacao.get(position).getNumeroLinha()));
        rbOnibus.setRating(arrayListAvaliacao.get(position).getNotaOnibus());
        rbOnibus.setIsIndicator(true);
        rbMotorista.setRating(arrayListAvaliacao.get(position).getNotaMotorista());
        rbMotorista.setIsIndicator(true);
        rbSeguranca.setRating(arrayListAvaliacao.get(position).getNotaSeguranca());
        rbSeguranca.setIsIndicator(true);
        rbLinha.setRating(arrayListAvaliacao.get(position).getNotaLinha());
        rbLinha.setIsIndicator(true);

        return rowView;
    }
}