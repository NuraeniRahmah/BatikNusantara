package com.example.batiknusantara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvku;

    RecyclerView.LayoutManager layoutManager;
    ApiInterface apiInterface;
    BatikAdapter batikAdapter;
    List<Batik> listBatiknya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvku=(RecyclerView)findViewById(R.id.rv_Batik);
        layoutManager=new LinearLayoutManager(this);
        rvku.setLayoutManager(layoutManager);
        Intent intent=getIntent();
        listBatiknya= (List<Batik>) intent.getSerializableExtra("batikkk");
        batikAdapter=new BatikAdapter(listBatiknya,MainActivity.this);
        rvku.setAdapter(batikAdapter);

        }
    }

