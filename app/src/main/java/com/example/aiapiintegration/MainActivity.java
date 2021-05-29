package com.example.aiapiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mlapi.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AIAPIinterface AI = retrofit.create(AIAPIinterface.class);
        Call<String> call = AI.show_marks(80.00);
        call.enqueue(new Callback<String>(){

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,response.code(),Toast.LENGTH_LONG);
                }
                String res = response.body();
                Log.i("Response",res);
                System.out.println(res);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG);
            }
        });
    }
}