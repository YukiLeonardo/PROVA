package br.unigran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

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
}