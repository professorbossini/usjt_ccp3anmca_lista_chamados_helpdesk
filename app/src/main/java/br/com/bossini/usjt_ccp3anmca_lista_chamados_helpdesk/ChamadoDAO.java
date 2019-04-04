package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChamadoDAO {

    private Context context;
    public ChamadoDAO (Context context){
        this.context = context;
    }

    public List<Chamado> busca (String chave){
        HelpDeskDBHelper dbHelper = new HelpDeskDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List <Chamado> chamados = new ArrayList <>();

        String sql = String.format(
          "SELECT * FROM %s INNER JOIN %s ON %s.%s = %s.%s WHERE %s.%s LIKE '%%%s%%'",
            HelpDeskContract.FilaContract.TABLE_NAME,
            HelpDeskContract.ChamadoContract.TABLE_NAME,
            HelpDeskContract.FilaContract.TABLE_NAME,
            HelpDeskContract.FilaContract.COLUMN_NAME_ID,
            HelpDeskContract.ChamadoContract.TABLE_NAME,
            HelpDeskContract.FilaContract.COLUMN_NAME_ID,
            HelpDeskContract.FilaContract.TABLE_NAME,
            HelpDeskContract.FilaContract.COLUMN_NAME_NOME,
            chave
        );
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int idChamado = cursor.getInt(cursor.getColumnIndex(
                    String.format("%s.%s",
                            HelpDeskContract.ChamadoContract.TABLE_NAME,
                            HelpDeskContract.ChamadoContract.COLUMN_NAME_ID)
            ));
            String descricao = cursor.getString(
              cursor.getColumnIndex(
                      String.format(
                              "%s.%s",
                              HelpDeskContract.ChamadoContract.TABLE_NAME,
                              HelpDeskContract.ChamadoContract.COLUMN_NAME_DESCRICAO
                      )
              )
            );
            int dtAbertura = cursor.getInt(
              cursor.getColumnIndex(
                      String.format(
                              "%s.%s",
                              HelpDeskContract.ChamadoContract.TABLE_NAME,
                              HelpDeskContract.ChamadoContract.COLUMN_NAME_DT_ABERTURA
                      )
              )
            );

            int dtFechamento = cursor.getInt(
              cursor.getColumnIndex(
                      String.format(
                              "%s.%s",
                              HelpDeskContract.ChamadoContract.TABLE_NAME,
                              HelpDeskContract.ChamadoContract.COLUMN_NAME_DT_FECHAMENTO
                      )
              )
            );

            String status = cursor.getString(
              cursor.getColumnIndex(
                      String.format(
                              "%s.%s",
                              HelpDeskContract.ChamadoContract.TABLE_NAME,
                              HelpDeskContract.ChamadoContract.COLUMN_NAME_STATUS
                      )
              )
            );
            int idFila = cursor.getInt(
              cursor.getColumnIndex(
                      String.format(
                              "%s.%s",
                              HelpDeskContract.FilaContract.TABLE_NAME,
                              HelpDeskContract.FilaContract.COLUMN_NAME_ID

                      )
              )
            );

            String nomeFila = cursor.getString(
                    cursor.getColumnIndex(
                            String.format(
                                    "%s.%s",
                                    HelpDeskContract.FilaContract.TABLE_NAME,
                                    HelpDeskContract.FilaContract.COLUMN_NAME_NOME
                            )
                    )
            );

            int iconId = cursor.getInt(
              cursor.getColumnIndex(
                      String.format(
                              "%s.%s",
                              HelpDeskContract.FilaContract.TABLE_NAME,
                              HelpDeskContract.FilaContract.COLUMN_NAME_ICON_ID
                      )
              )
            );
            chamados.add(
                new Chamado(
                        idChamado,
                        new Fila (idFila, nomeFila, iconId),
                        descricao,
                        new Date(dtAbertura),
                        dtFechamento == 0 ? null : new Date (dtFechamento),
                        status
                )
            );
        }
        cursor.close();
        dbHelper.close();
        db.close();
        return chamados;
    }
}
