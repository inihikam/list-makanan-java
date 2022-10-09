package com.example.listkuliner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recKuliner;
    private ArrayList<Kuliner> listKuliner;
    private KulinerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recKuliner = findViewById(R.id.recKuliner);
        initData();

        setOnClickListener();
        recKuliner.setAdapter(new KulinerAdapter(listKuliner, listener));
        recKuliner.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setOnClickListener() {
        listener = new KulinerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailMakanan.class);
                intent.putExtra("name", listKuliner.get(position).getNama());
                intent.putExtra("desc", listKuliner.get(position).getDeskripsi());
                intent.putExtra("price", listKuliner.get(position).getHarga());
                intent.putExtra("image", listKuliner.get(position).getId_gambar());
                startActivity(intent);
            }
        };
    }

    private void initData(){
        this.listKuliner = new ArrayList<>();
        listKuliner.add(new Kuliner("Nasi Goreng Jawa", "Nasi Goreng khas Jawa\ndengan cita rasa menggugah selera", "20.000", R.drawable.nasgor));
        listKuliner.add(new Kuliner("Bakmie Goreng Jawa", "Bakmie Goreng khas Jawa\ndengan cita rasa menggugah selera", "22.000", R.drawable.bakmiejawa));
        listKuliner.add(new Kuliner("Bakso Urat", "Bakso urat\ndengan daging sapi pilihan", "25.000", R.drawable.bakso));
        listKuliner.add(new Kuliner("Sate Kelinci", "Sate dengan daging kelinci yang\ncocok dimakan di suasana dingin", "30.000", R.drawable.satekelinci));
        listKuliner.add(new Kuliner("Tahu Gimbal", "Tahu campur yang\ndipadukan dengan gimbal udang", "25.000", R.drawable.tahugimbal));
    }
}