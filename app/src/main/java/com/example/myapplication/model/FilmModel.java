package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmModel implements Parcelable {

    public FilmModel(String nama_film, String keterangan, String poster) {
        this.nama_film = nama_film;
        this.keterangan = keterangan;
        this.poster = poster;
    }
    private String keterangan;

    private String id;

    private String nama_film;

    private String poster;

    protected FilmModel(Parcel in) {
        keterangan = in.readString();
        id = in.readString();
        nama_film = in.readString();
        poster = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(keterangan);
        dest.writeString(id);
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

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
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
