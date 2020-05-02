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
import com.dicoding.picodiploma.moviecatalogue.adapter.ShowAdapter;
import com.dicoding.picodiploma.moviecatalogue.parcelable.TvShow;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShows extends Fragment {
    private RecyclerView rvShows;
    private ArrayList<TvShow> list = new ArrayList<>();


    private String[] dataShowName;
    private String[] dataShowDescription;
    private String[] dataShowRelease;
    private TypedArray dataShowPoster;
    private ArrayList<TvShow> tvshows;

    public TvShows() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        rvShows = view.findViewById(R.id.rv_tv_show);
        rvShows.setHasFixedSize(true);

        list.addAll(getListTvShows());
        showRecyclerList();


        return view;
    }


    private ArrayList<TvShow> getListTvShows() {
        {
            dataShowName = getResources().getStringArray(R.array.show_name);
            dataShowRelease = getResources().getStringArray(R.array.show_release);
            dataShowDescription = getResources().getStringArray(R.array.show_description);
            dataShowPoster = getResources().obtainTypedArray(R.array.show_poster);

        }
        ArrayList<TvShow> listTvShow = new ArrayList<>();
        for (int i = 0; i < dataShowName.length; i++) {
            TvShow tvshow = new TvShow();
            tvshow.setName(dataShowName[i]);
            tvshow.setRelease(dataShowRelease[i]);
            tvshow.setDescription(dataShowDescription[i]);
            tvshow.setPhoto(dataShowPoster.getResourceId(i,-1));
            listTvShow.add(tvshow);

        }
        return listTvShow;
    }


    private void showRecyclerList () {


        rvShows.setLayoutManager(new LinearLayoutManager(getContext()));
        ShowAdapter showAdapter = new ShowAdapter(list);
        rvShows.setAdapter(showAdapter);


    }

}
