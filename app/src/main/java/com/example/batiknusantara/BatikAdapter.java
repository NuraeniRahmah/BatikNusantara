package com.example.batiknusantara;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BatikAdapter extends RecyclerView.Adapter<BatikAdapter.BatikHolder> {
    List<Batik> batiknya;
    Activity activity;

    public BatikAdapter(List<Batik> batiknya, Activity activity) {
        this.batiknya = batiknya;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BatikHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rv_item, parent, false);
        return new BatikHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BatikHolder holder, final int position) {
        holder.txtNama.setText(batiknya.get(position).getNama_batik());
        holder.txtDaerah.setText(batiknya.get(position).getDaerah_batik());
        holder.txtHarga.setText(batiknya.get(position).getHarga_tinggi());
        Picasso.with(activity).load(batiknya.get(position).getLink_batik()).into(holder.imgku);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Batik kirimBatik=batiknya.get(position);
                Intent pindah=new Intent(activity,DetailActivity.class);
                pindah.putExtra(DetailActivity.KEY,kirimBatik);
                v.getContext().startActivity(pindah);
            }
        });


    }

    @Override
    public int getItemCount() {
        return batiknya.size();
    }

    static class BatikHolder extends RecyclerView.ViewHolder {
        ImageView imgku;
        TextView txtNama, txtDaerah, txtHarga;

        public BatikHolder(@NonNull View itemView) {
            super(itemView);
            imgku = (ImageView) itemView.findViewById(R.id.img_batik);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtDaerah = (TextView) itemView.findViewById(R.id.txt_daerah);
            txtHarga = (TextView) itemView.findViewById(R.id.txt_harga);
        }
    }

}
