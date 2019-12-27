package com.example.myapplication.database;

import android.app.Application;

import androidx.room.Room;

public class BaseApp extends Application {

    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "FAVORITE").allowMainThreadQueries().build();
    }
}
