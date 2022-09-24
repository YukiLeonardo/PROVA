package br.unigran;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.unigran.BancoDados.AbastecimentoDB;
import br.unigran.BancoDados.DBHelper;


public class MainActivity extends AppCompatActivity {
    EditText km;
    EditText qntAbs;
    EditText data;
    EditText valor;
    Button media;
    ListView listagem;
    List<Abastecimento> dados;
    DBHelper db;
    AbastecimentoDB abastecimentoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBHelper(this);
        setContentView(R.layout.activity_main);

        km=findViewById(R.id.id_kmAtual);
        qntAbs=findViewById(R.id.id_qntAbastecimento);
        data=findViewById(R.id.id_data);
        valor=findViewById(R.id.id_valor);
        media = findViewById(R.id.id_calcular);

        listagem=findViewById(R.id.id_list);
        dados= new ArrayList();
        ArrayAdapter adapter =
                new ArrayAdapter(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dados);
        listagem.setAdapter(adapter);

        abastecimentoDB =new AbastecimentoDB(db);
        abastecimentoDB.lista(dados);
        ((ArrayAdapter) listagem.getAdapter()
        ).notifyDataSetChanged();

        acao();

    }

    public void acao(){
        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(view.getContext())
                        .setMessage("Deseja realmente remover")
                        .setPositiveButton("Confirmar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface,
                                                        int k) {
                                        Abastecimento abastecimento = dados.get(i);
                                        abastecimentoDB.remover(abastecimento.getId());
                                        abastecimentoDB.lista(dados);
                                        ((ArrayAdapter) listagem.getAdapter()
                                        ).notifyDataSetChanged();
                                    }
                                })
                        .setNegativeButton("cancelar",null)
                        .create().show();
            }
        });
    }

    public void salvar(View view){
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setKm(km.getText().toString());
        abastecimento.setQntAbs(qntAbs.getText().toString());
        abastecimento.setData(data.getText().toString());
        abastecimento.setValor(valor.getText().toString());
        abastecimentoDB.inserir(abastecimento);
        abastecimentoDB.lista(dados);

        ((ArrayAdapter) listagem.getAdapter()
        ).notifyDataSetChanged();
        Toast.makeText(this,"Salvo com sucesso",Toast.LENGTH_SHORT)
                .show();
    }
}