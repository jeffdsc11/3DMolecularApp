package com.example.a3dmolecularapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
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

        getFullStrutures();
    }

    private void getFullStrutures(){
        Call<List<FullStruture>> call = jsonPlaceHolderApi.getFullStruture("1tqn");

        call.enqueue(new Callback<List<FullStruture>>() {
            @Override
            public void onResponse(Call<List<FullStruture>> call, Response<List<FullStruture>> response) {

                if(!response.isSuccessful()){
                    textResult.setText("Code: " + response.code());
                    return;
                }

                List<FullStruture> fullStrutures = response.body();

                for (FullStruture fullStruture: fullStrutures){
                    String content = "";
                    content += "ID: " + fullStruture.getId() + "\n";
                    content += "Model nums: " + fullStruture.getModel_nums() + "\n";
                    content += "Encoding: " + fullStruture.getEncoding() + "\n";
                    content += "Copy All Categories: " + fullStruture.getCopy_all_categories() + "\n";
                    content += "Data Source: " + fullStruture.getData_source() + "\n";
                    content += "Transform: " + fullStruture.getTransform() + "\n";
                    content += "Download: " + fullStruture.getDownload() + "\n";
                    content += "File name: " + fullStruture.getDownload()+ "\n\n";

                    textResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<FullStruture>> call, Throwable t) {
                textResult.setText(t.getMessage());
            }
        });
    }

}




