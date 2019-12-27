package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FilmModel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nama_film")
    private String nama_film;
    @ColumnInfo(name = "keterangan")
    private String keterangan;
    @ColumnInfo(name = "poster")
    private String poster;

    public FilmModel(String nama_film, String keterangan, String poster) {
        this.nama_film = nama_film;
        this.keterangan = keterangan;
        this.poster = poster;
    }


    protected FilmModel(Parcel in) {
        keterangan = in.readString();
        id = Integer.valueOf(in.readString());
        nama_film = in.readString();
        poster = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(keterangan);
        dest.writeString(String.valueOf(id));
        dest.writeString(nama_film);
        dest.writeString(poster);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FilmModel> CREATOR = new Creator<FilmModel>() {
        @Override
        public FilmModel createFromParcel(Parcel in) {
            return new FilmModel(in);
        }

        @Override
        public FilmModel[] newArray(int size) {
            return new FilmModel[size];
        }
    };

    public String getKeterangan ()
    {
        return keterangan;
    }



    public void setKeterangan (String keterangan)
    {
        this.keterangan = keterangan;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getNama_film ()
    {
        return nama_film;
    }

    public void setNama_film (String nama_film)
    {
        this.nama_film = nama_film;
    }

    public String getPoster ()
    {
        return poster;
    }

    public void setPoster (String poster)
    {
        this.poster = poster;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [keterangan = "+keterangan+", id = "+id+", nama_film = "+nama_film+", poster = "+poster+"]";
    }
}
