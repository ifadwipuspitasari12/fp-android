package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailFilmActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.FilmModel;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import static com.example.myapplication.DetailFilmActivity.DATA_FILM;


public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CustomViewHolder> {

    private List<FilmModel> dataList;
    private Context context;

    public FilmAdapter(Context context, List<FilmModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.txtFilm.setText(dataList.get(position).getNama_film());
        holder.txtKeterangan.setText(dataList.get(position).getKeterangan());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFilmActivity.class);
                intent.putExtra(DATA_FILM, dataList.get(position));
                context.startActivity(intent);
            }
        });
        String img = dataList.get(position).getPoster();

        Picasso.get().load(img).into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private TextView txtFilm;
        private TextView txtKeterangan;
        private ImageView coverImage;
        private CardView cardView;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtFilm = mView.findViewById(R.id.tv_nama_film);
            txtKeterangan = mView.findViewById(R.id.tv_keterangan);
            coverImage = mView.findViewById(R.id.coverImage);
            cardView = mView.findViewById(R.id.card_view_friend);
        }
    }


}
