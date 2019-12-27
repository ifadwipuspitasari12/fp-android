package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.FilmModel;

import java.util.List;

@Dao
public interface FavoritDao {

    @Query("SELECT * FROM filmmodel")
    List<FilmModel> getAll();

    @Insert
    long insertFav(FilmModel film);

}
