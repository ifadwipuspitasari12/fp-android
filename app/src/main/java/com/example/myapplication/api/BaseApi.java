package com.example.myapplication.api;

import com.example.myapplication.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApi {
    @GET("get/list/movie/all")
    Call<List<FilmModel>> getAllMovie();
}
