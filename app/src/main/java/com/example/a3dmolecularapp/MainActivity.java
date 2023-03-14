package com.example.a3dmolecularapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Itens para conectar com a interface principal
    private Button botao;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conexao com a interface principal
        botao = (Button) findViewById(R.id.Bbotao);
        texto = (TextView) findViewById(R.id.Ttexto);

        //Adiciona a funcao ao botao
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarefa tarefa = new Tarefa();
                //Realiza o teste de conexão com o banco
                tarefa.execute("https://search.rcsb.org/rcsbsearch/v2/query?json=%7B%22query%22%3A%7B%22type%22%3A%22terminal%22%2C%22service%22%3A%22full_text%22%2C%22parameters%22%3A%7B%22value%22%3A%22thymidine%20kinase%22%7D%7D%2C%22return_type%22%3A%22entry%22%7D");
            }
        });
    }

    //A classe conexao devera ficar funcionando em segundo plano, o comando protected String doInBackground será responsável por isso.
    private class Tarefa extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            texto.setText(s);
        }
    }

}