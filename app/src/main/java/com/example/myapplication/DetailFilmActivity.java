package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.model.FilmModel;
import com.squareup.picasso.Picasso;

public class DetailFilmActivity extends AppCompatActivity {

    public static String DATA_FILM = "data_film";
    TextView tvNamaFilm, tvKeterangan;
    ImageView imgDetailFilm;
    AppDatabase db;
    Button btnSaveFavorit;
    String img, namaFilm, keterangan, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        tvNamaFilm = findViewById(R.id.tv_nama_film);
        tvKeterangan = findViewById(R.id.tv_detail_keterangan);
        imgDetailFilm = findViewById(R.id.img_detail);
        btnSaveFavorit = findViewById(R.id.btn_save_favorit);

        // initiate pemanggilan Room database
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "FAVORITE").build();

        Intent intent = getIntent();
        FilmModel data = intent.getParcelableExtra(DATA_FILM);

        img = data.getPoster();
        id = String.valueOf(data.getId());
        namaFilm = data.getNama_film();
        keterangan = data.getKeterangan();


        tvNamaFilm.setText(data.getNama_film());
        tvKeterangan.setText(data.getKeterangan());
        Picasso.get().load(img).into(imgDetailFilm);

        btnSaveFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FilmModel film = new FilmModel(namaFilm, keterangan, img);
                insertData(film);
            }

            private void insertData(final FilmModel wisata) {
                new AsyncTask<Void, Void, Long>() {
                    @Override
                    protected Long doInBackground(Void... voids) {
                        long status = db.favoriteDao().insertFav(wisata);
                        return status;
                    }

                    @Override
                    protected void onPostExecute(Long status) {
                        Toast.makeText(DetailFilmActivity.this, "Insert data berhasil " + status, Toast.LENGTH_SHORT).show();
                        sendPushNotification();
                    }

                    private void sendPushNotification() {
                        NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                        Notification notify=new Notification.Builder
                                (getApplicationContext()).setContentTitle("data telah masuk").setContentText("data telah masuk").
                                setContentTitle("data telah masuk").setSmallIcon(R.drawable.ic_archive_black_24dp).build();

                        notify.flags |= Notification.FLAG_AUTO_CANCEL;
                        notif.notify(0, notify);

                    }
                }.execute();
            }
        });


    }
}