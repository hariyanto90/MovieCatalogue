package com.dicoding.picodiploma.moviecatalogue.adapter;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.dicoding.picodiploma.moviecatalogue.R;
import com.dicoding.picodiploma.moviecatalogue.fragment.Movies;
import com.dicoding.picodiploma.moviecatalogue.fragment.TvShows;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2
    };


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Movies();
                break;

            case 1:
                fragment = new TvShows();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return mContext.getResources().getString(TAB_TITLES[position]);

    }

    @Override
    public int getCount() {
        return 2;
    }
}
