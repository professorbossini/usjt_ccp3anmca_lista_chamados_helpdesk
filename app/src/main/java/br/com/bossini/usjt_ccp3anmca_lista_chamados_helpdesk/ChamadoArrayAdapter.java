package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ChamadoArrayAdapter extends
        ArrayAdapter <Chamado> {

    public ChamadoArrayAdapter (Context context, List<Chamado> chamados){
        super(context, -1, chamados);
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        if (convertView == null){
            Context context = getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        }
        Chamado caraDaVez = getItem (position);

        ImageView filaIconImageView = convertView.findViewById(R.id.filaIconImageView);
        TextView descricaoChamadoTextView =
                convertView.findViewById(R.id.descricaoChamadoTextView);
        TextView dataAberturaChamadoTextView =
                convertView.findViewById(R.id.dataAberturaChamadoTextView);
        TextView dataFechamentoChamadoTextView =
                convertView.findViewById(R.id.dataFechamentoChamadoTextView);
        TextView statusChamadoTextView =
                convertView.findViewById(R.id.statusChamadoTextView);
        filaIconImageView.setImageResource(caraDaVez.getFila().getIconId());
        descricaoChamadoTextView.setText(caraDaVez.getDescricao());
        dataAberturaChamadoTextView.setText(
                DateHelper.format(
                        caraDaVez.getDataAbertura()
                ));
        if (caraDaVez.getDataFechamento() != null){
            dataFechamentoChamadoTextView.setText(
                    DateHelper.format(
                            caraDaVez.getDataFechamento()
                    )
            );
        }
        statusChamadoTextView.setText(
                caraDaVez.getStatus()
        );

        return convertView;
    }
}
