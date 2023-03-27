package com.example.a3dmolecularapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.Tresult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://models.rcsb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getFullStructure("4hhb");
    }

    private void getFullStructure(String modelId) {
        // Faz uma chamada assíncrona para buscar as informações do modelo
        Call<ResponseBody> call = jsonPlaceHolderApi.getFullStructure(modelId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        // Converte o corpo da resposta em uma string e exibe no TextView
                        String modelInfo = response.body().string();
                        textResult.setText(modelInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Trata o erro caso a requisição falhe
                    textResult.setText("Erro ao buscar informações do modelo");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Trata o erro caso ocorra uma falha na conexão
                textResult.setText("Falha na conexão com a API");
            }
        });
    }

}




