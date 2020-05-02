package com.dicoding.picodiploma.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.picodiploma.moviecatalogue.parcelable.TvShow;

public class DetailTvActivity extends AppCompatActivity {
    TextView showName, showRelease, showDescription;
    ImageView showPoster;



    public static final String EXTRA_TV = "extra_tv"; // Kode untuk menerima obyek dari activity Asal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        showName = findViewById(R.id.show_name);
        showRelease = findViewById(R.id.show_release);
        showDescription = findViewById(R.id.show_description);
        showPoster= findViewById(R.id.img_show);

        // Kode untuk menerima obyek dari activity Asal
        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TV);
        assert tvShow !=null;
        showName.setText(tvShow.getName());
        showRelease.setText(tvShow.getRelease());
        showDescription.setText(tvShow.getDescription());
        int shPoster = tvShow.getPhoto();
        showPoster.setImageResource(shPoster);


    }
}
