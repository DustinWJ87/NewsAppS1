package com.example.android.newsapps1;

import android.content.Context;
import android.content.AsyncTaskLoader;
import android.support.annotation.Nullable;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Query URL
     */
    private String URL;

    /**
     * Constructs a new NewsLoader
     *
     * @param context of the Activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        URL = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<News> loadInBackground() {
        if (URL == null) {
            return null;
        }

        List<News> news = QueryUtils.fetchNewsData(URL);
        return news;
    }
}