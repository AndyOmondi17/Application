package com.example.final_application.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.final_application.Anime;
import com.example.final_application.R;

public class dateAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mAnime;
    private String[] mDaterelease;

    public dateAdapter(Context mContext, int resource, String[] mAnime, String[] mDaterelease) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mAnime = mAnime;
        this.mDaterelease = mDaterelease;
    }

    @Override
    public Object getItem(int position) {
        String anime = mAnime[position];
        String dateRelease = mDaterelease[position];
        return String.format("%s \nServes great: %s", anime, dateRelease);
    }

    @Override
    public int getCount() {
        return mAnime.length;
    }



}
