package com.example.listkuliner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.ViewHolder> {

    private ArrayList<Kuliner> listKuliner;
    private RecyclerViewClickListener listener;

    public KulinerAdapter(ArrayList<Kuliner> listKuliner, RecyclerViewClickListener listener) {
        this.listKuliner = listKuliner;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KulinerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.itemkuliner, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KulinerAdapter.ViewHolder holder, int position) {
        Kuliner kuliner = listKuliner.get(position);
        holder.txtNama.setText(kuliner.getNama());
        holder.txtDesc.setText(kuliner.getDeskripsi());
        holder.txtHarga.setText(kuliner.getHarga());
        holder.imgKuliner.setImageResource(kuliner.getId_gambar());



    }

    @Override
    public int getItemCount() {
        return listKuliner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtNama, txtDesc, txtHarga;
        public ImageView imgKuliner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
            txtHarga = (TextView) itemView.findViewById(R.id.txtHarga);
            imgKuliner = (ImageView) itemView.findViewById(R.id.imgKuliner);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
