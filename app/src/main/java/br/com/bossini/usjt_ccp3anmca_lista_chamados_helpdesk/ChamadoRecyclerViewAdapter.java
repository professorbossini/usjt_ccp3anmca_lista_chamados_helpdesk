package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChamadoRecyclerViewAdapter
        extends RecyclerView.Adapter<ChamadoViewHolder>{

    private List<Chamado> chamados;

    public ChamadoRecyclerViewAdapter (List <Chamado> chamados){
        this.chamados = chamados;
    }

    @Override
    public int getItemCount() {
        return chamados.size();
    }

    @NonNull
    @Override
    public ChamadoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View raiz =
                LayoutInflater.from(viewGroup.getContext()).
                        inflate(R.layout.list_item, viewGroup, false);
        return new ChamadoViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamadoViewHolder chamadoViewHolder, int i) {
        Chamado chamadoDaVez = chamados.get(i);
        chamadoViewHolder.filaIconImageView.
                setImageResource(chamadoDaVez.getFila().getIconId());
        chamadoViewHolder.descricaoChamadoTextView.setText(chamadoDaVez.getDescricao());
        chamadoViewHolder.statusChamadoTextView.setText(chamadoDaVez.getStatus());
        chamadoViewHolder.dataAberturaChamadoTextView.
                setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if (chamadoDaVez.getDataFechamento() != null)
            chamadoViewHolder.dataFechamentoChamadoTextView.
                setText(DateHelper.format(chamadoDaVez.getDataFechamento()));
    }


}
