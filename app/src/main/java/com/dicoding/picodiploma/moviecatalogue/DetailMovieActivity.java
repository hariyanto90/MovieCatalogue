package com.dicoding.picodiploma.moviecatalogue;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.picodiploma.moviecatalogue.parcelable.Movie;

public class DetailMovieActivity extends AppCompatActivity {
    TextView txtName, txtRelease, txtDescription;
    ImageView imgPhoto;



    public static final String EXTRA_MOVIE = "extra_movie"; // Kode untuk menerima obyek dari activity Asal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imgPhoto = findViewById(R.id.img_poster);
        txtName = findViewById(R.id.txt_name);
        txtRelease = findViewById(R.id.txt_release);
        txtDescription= findViewById(R.id.txt_description);

        // Kode untuk menerima obyek dari activity Asal
        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        assert movie !=null;
        txtName.setText(movie.getName());
        txtRelease.setText(movie.getRelease());
        txtDescription.setText(movie.getDescription());
        int poster = movie.getPhoto();
        imgPhoto.setImageResource(poster);


    }
}
