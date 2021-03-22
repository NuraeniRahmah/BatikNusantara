package com.example.batiknusantara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    ApiInterface apiInterface;
    SemuaBatik databatikku;
    List<Batik> listBatiknya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new AmbilBatik().execute();
    }

    private class AmbilBatik extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface=ApiCilent.ambilBatik().create(ApiInterface.class);
            Call<SemuaBatik> call=apiInterface.getsemuabatik();
            call.enqueue(new Callback<SemuaBatik>() {
                @Override
                public void onResponse(Call<SemuaBatik> call, Response<SemuaBatik> response) {
                    databatikku=response.body();
                    listBatiknya=databatikku.getHasil();
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    intent.putExtra("batikkk", (Serializable) listBatiknya);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<SemuaBatik> call, Throwable t) {
                    Toast.makeText(SplashScreen.this,"gak dapet data",Toast.LENGTH_LONG).show();

                }
            });
            return null;
        }
    }
}
