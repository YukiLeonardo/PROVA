package br.unigran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText km;
    EditText qntAbs;
    EditText data;
    EditText valor;
    ListView listagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        km=findViewById(R.id.id_kmAtual);
        qntAbs=findViewById(R.id.id_qntAbastecimento);
        data=findViewById(R.id.id_data);
        valor=findViewById(R.id.id_valor);
        listagem=findViewById(R.id.id_list);
    }
    public void salvar(View view){
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setKm(km.getText().toString());
        abastecimento.setQntAbs(qntAbs.getText().toString());
        abastecimento.setData(data.getText().toString());
        abastecimento.setValor(valor.getText().toString());

        Toast.makeText(this,"Salvo com sucesso",Toast.LENGTH_SHORT)
                .show();
    }
}