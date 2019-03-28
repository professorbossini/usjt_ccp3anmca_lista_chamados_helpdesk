package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChamadoViewHolder extends RecyclerView.ViewHolder {

    public ImageView filaIconImageView;
    public TextView descricaoChamadoTextView;
    public TextView statusChamadoTextView;
    public TextView dataAberturaChamadoTextView;
    public TextView dataFechamentoChamadoTextView;

    public ChamadoViewHolder (View v){
        super(v);
        filaIconImageView =
                v.findViewById(R.id.filaIconImageView);
        descricaoChamadoTextView =
                v.findViewById(R.id.descricaoChamadoTextView);
        statusChamadoTextView =
                v.findViewById(R.id.statusChamadoTextView);
        dataAberturaChamadoTextView =
                v.findViewById(R.id.dataAberturaChamadoTextView);
        dataFechamentoChamadoTextView =
                v.findViewById(R.id.dataFechamentoChamadoTextView);
    }
}
