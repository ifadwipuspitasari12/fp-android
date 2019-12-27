package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.adapter.FilmAdapter;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.FavoritDao;
import com.example.myapplication.model.FilmModel;

import java.util.ArrayList;
import java.util.List;

public class SimpanActivity extends AppCompatActivity {

    private FilmAdapter adapter;
    private RecyclerView recyclerView;
    List<FilmModel> listWisata = new ArrayList<>();
    private FavoritDao favoriteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpan);
        favoriteDao = AppDatabase.getInstance(this).favoriteDao();
        recyclerView = findViewById(R.id.rvSimpan);
        setAdapter();
        fetchDataFromRoom();
    }

    private void setAdapter() {
        adapter = new FilmAdapter(this, listWisata);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fetchDataFromRoom() {

        listWisata.addAll(favoriteDao.getAll());
        adapter.notifyDataSetChanged();

        //just checking data from db
        for (int i = 0; i < listWisata.size(); i++) {
            Log.e("Aplikasi", listWisata.get(i).getNama_film() + i);
            Log.e("Aplikasi", listWisata.get(i).getKeterangan() + i);
            Log.e("Aplikasi", listWisata.get(i).getPoster() + i);
        }

    }
}