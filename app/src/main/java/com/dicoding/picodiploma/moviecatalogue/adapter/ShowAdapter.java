package com.dicoding.picodiploma.moviecatalogue.adapter;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.dicoding.picodiploma.moviecatalogue.DetailTvActivity;
import com.dicoding.picodiploma.moviecatalogue.R;
import com.dicoding.picodiploma.moviecatalogue.parcelable.TvShow;

import java.util.ArrayList;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ListViewHolder> {
    private ArrayList<TvShow> listShow;

    public ShowAdapter (ArrayList<TvShow> list) {
        this.listShow = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false);
        return new ShowAdapter.ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final TvShow tvShow = listShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPhoto())
                .into(holder.showPoster);
        holder.showName.setText(tvShow.getName());
        holder.showRelease.setText(tvShow.getRelease());
        holder.showDescription.setText(tvShow.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TvShow tvShow1 = new TvShow();
                tvShow1.setPhoto(tvShow.getPhoto());
                tvShow1.setName(tvShow.getName());
                tvShow1.setRelease(tvShow.getRelease());
                tvShow1.setDescription(tvShow.getDescription());

                Intent intent = new Intent(view.getContext(), DetailTvActivity.class);
                intent.putExtra("extra_tv",tvShow1);
                view.getContext().startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return listShow.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView showPoster;
        TextView showName, showRelease, showDescription;


        public ListViewHolder(@NonNull View view) {
            super(view);
            showName = view.findViewById(R.id.show_name);
            showRelease = view.findViewById(R.id.show_release);
            showDescription = view.findViewById(R.id.show_description);
            showPoster = view.findViewById(R.id.img_show);


        }
    }
}
