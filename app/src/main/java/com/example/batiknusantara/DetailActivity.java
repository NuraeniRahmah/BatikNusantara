package com.example.batiknusantara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    TextView txtNamaBatik,txtAsalBatik,txtKet;
    ImageView imgBatik,imgPanah;
    public static String KEY="keynya";
    Batik hasilBatik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtNamaBatik=(TextView)findViewById(R.id.txt_nama_batik);
        imgBatik=(ImageView)findViewById(R.id.txt_img_ukir);
        imgPanah=(ImageView)findViewById(R.id.img_panah) ;
        txtAsalBatik=(TextView)findViewById(R.id.txt_asal_batik);
        txtKet=(TextView)findViewById(R.id.txt_ket);
        Intent dapet=getIntent();
        hasilBatik= (Batik) dapet.getSerializableExtra("keynya");
        txtNamaBatik.setText(hasilBatik.getNama_batik());
        txtAsalBatik.setText(hasilBatik.getDaerah_batik());
        txtKet.setText(hasilBatik.getMakna_batik());
        Picasso.with(this).load(hasilBatik.getLink_batik()).into(imgBatik);
        imgPanah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah=new Intent(DetailActivity.this,MainActivity.class);
                startActivity(pindah);
            }
        });




    }
}
