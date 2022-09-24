package br.unigran.BancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.Abastecimento;

public class AbastecimentoDB {
    private DBHelper db;
    private SQLiteDatabase conexao;


    public AbastecimentoDB(DBHelper db){
            this.db = db;
        }

        public void inserir(Abastecimento abastecimento){
            conexao = db.getWritableDatabase();//abri o bd
            ContentValues valores = new ContentValues();
            valores.put("km",abastecimento.getKm());
            valores.put("qntAbs",abastecimento.getQntAbs());
            valores.put("data",abastecimento.getData());
            valores.put("valor",abastecimento.getValor());
            conexao.insert("abastecimentos",null,valores);
            conexao.close();
        }
        public void remover(int id){
            conexao=db.getWritableDatabase();
            conexao.delete("abastecimentos","id=?",
                    new String[]{id+""});
        }
        public void lista(List dados){
            dados.clear();
            conexao=db.getReadableDatabase();
            String names[]={"id","km","qntAbs, data, valor"};
            Cursor query = conexao.query("abastecimentos", names,
                    null, null, null,
                    null, "km");
            while (query.moveToNext()){
                Abastecimento abastecimento = new Abastecimento();
                abastecimento
                        .setId(Integer.parseInt(
                        query.getString(0)));
                abastecimento.setKm(
                        query.getString(1));
                abastecimento.setQntAbs(
                        query.getString(2));
                abastecimento.setData(
                        query.getString(3));
                abastecimento.setValor(
                        query.getString(4));

                dados.add(abastecimento);
            }
            conexao.close();
        }

}
