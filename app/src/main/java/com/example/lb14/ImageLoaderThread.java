package com.example.lb14;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ImageLoaderThread extends Thread {
    private final List<Movie> movies;
    private final MovieAdapter adapter;
    private final Handler handler;

    public ImageLoaderThread(List<Movie> movies, MovieAdapter adapter) {
     //   this.players = players;
        this.movies = movies;
        this.adapter = adapter;
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void run() {
        for (Movie movie :movies) {
            Bitmap bitmap = downloadImage(movie.getImageUrl());

            if (bitmap != null) {
               movie.setBitmap(bitmap);

                handler.post(adapter::notifyDataSetChanged);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Bitmap downloadImage(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream input = connection.getInputStream();
                return BitmapFactory.decodeStream(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}