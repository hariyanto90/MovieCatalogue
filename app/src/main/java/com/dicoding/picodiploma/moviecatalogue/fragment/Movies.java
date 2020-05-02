package com.dicoding.picodiploma.moviecatalogue.fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dicoding.picodiploma.moviecatalogue.R;
import com.dicoding.picodiploma.moviecatalogue.adapter.MovieAdapter;
import com.dicoding.picodiploma.moviecatalogue.parcelable.Movie;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class Movies extends Fragment  {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

   // private MovieAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataRelease;
    private TypedArray dataPoster;
    private ArrayList<Movie> movies;


    public Movies() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Fungsi onCreateView sebaiknya hanya digunakan untuk melakukan inflate view. Untuk inisialisasi view sebaiknya dilakukan di dalam fungsi onViewCreated. 
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        list.addAll(getListMovies());
        showRecyclerList();


        return view;
    }


    private ArrayList<Movie> getListMovies() {
        {
            dataName = getResources().getStringArray(R.array.data_name);
            dataRelease = getResources().getStringArray(R.array.data_release);
            dataDescription = getResources().getStringArray(R.array.data_description);
            dataPoster = getResources().obtainTypedArray(R.array.data_poster);

        }
        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setRelease(dataRelease[i]);
            movie.setDescription(dataDescription[i]);
            movie.setPhoto(dataPoster.getResourceId(i,-1));
            listMovie.add(movie);

        }
        return listMovie;
    }


      private void showRecyclerList () {


      rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
       MovieAdapter movieAdapter = new MovieAdapter(list);
      rvMovies.setAdapter(movieAdapter);



       }

}

