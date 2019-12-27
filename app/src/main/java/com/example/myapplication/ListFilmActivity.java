package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.adapter.FilmAdapter;
import com.example.myapplication.api.BaseApi;
import com.example.myapplication.api.RetrofitClient;
import com.example.myapplication.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFilmActivity extends AppCompatActivity {

    private FilmAdapter adapter;
    private RecyclerView recyclerView;
   // ProgressDialog progressDoalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_film);
//        progressDoalog = new ProgressDialog(ListFilmActivity.this);
//        progressDoalog.setMessage("Loading....");
//        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        BaseApi service = RetrofitClient.getRetrofitInstance().create(BaseApi.class);
        Call<List<FilmModel>> call = service.getAllMovie();
        call.enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
//                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
             //   progressDoalog.dismiss();
                Toast.makeText(ListFilmActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<FilmModel> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new FilmAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListFilmActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}

