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
import com.dicoding.picodiploma.moviecatalogue.DetailMovieActivity;
import com.dicoding.picodiploma.moviecatalogue.R;
import com.dicoding.picodiploma.moviecatalogue.parcelable.Movie;
import java.util.ArrayList;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie;

    public MovieAdapter (ArrayList<Movie> list) {
        this.listMovie = list;
    }




    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        final Movie movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .into(holder.imgPoster);
        holder.txtName.setText(movie.getName());
        holder.txtRelease.setText(movie.getRelease());
        holder.txtDescription.setText(movie.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Movie movie1 = new Movie();
                movie1.setPhoto(movie.getPhoto());
                movie1.setName(movie.getName());
                movie1.setRelease(movie.getRelease());
                movie1.setDescription(movie.getDescription());

                Intent intent = new Intent(view.getContext(), DetailMovieActivity.class);
                intent.putExtra("extra_movie",movie1);
                view.getContext().startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }





    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView txtName, txtRelease, txtDescription;


        public ListViewHolder(@NonNull View view) {
            super(view);
            txtName = view.findViewById(R.id.txt_name);
            txtRelease = view.findViewById(R.id.txt_release);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPoster = view.findViewById(R.id.img_poster);


        }
    }
}