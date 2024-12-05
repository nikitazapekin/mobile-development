package com.example.lb14;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoaderThread {
    private final List<Movie> movies;
    private final MovieAdapter adapter;
    private final Handler handler;
    private final ExecutorService executorService;

    public ImageLoaderThread(List<Movie> movies, MovieAdapter adapter) {
        this.movies = movies;
        this.adapter = adapter;
        this.handler = new Handler(Looper.getMainLooper());
        this.executorService = Executors.newSingleThreadExecutor();
    }


/*
    public void loadImagesSequentially() {
        for (Movie movie : movies) {
            new Thread(() -> {
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
            }).start();
        }
    }
*/

    public void loadImagesSequentially() {
        new Thread(() -> {
            for (Movie movie : movies) {
                Thread thread = new Thread(() -> {
                    Bitmap bitmap = downloadImage(movie.getImageUrl());
                    if (bitmap != null) {
                        movie.setBitmap(bitmap);


                        handler.post(adapter::notifyDataSetChanged);
                    }
                });

                thread.start();

                try {

                    thread.join();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /*
    public void loadImagesSequentially() {
        new Thread(() -> {
            for (Movie movie : movies) {
                Thread thread = new Thread(() -> {
                    Bitmap bitmap = downloadImage(movie.getImageUrl());
                    if (bitmap != null) {
                        movie.setBitmap(bitmap);

                        // Обновляем UI из главного потока
                        handler.post(adapter::notifyDataSetChanged);
                    }
                });

                thread.start();

                try {
                    // Задержка между созданием новых потоков
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
*/
    /*  public void loadImagesSequentially() {
        for (Movie movie : movies) {
            executorService.submit(() -> {
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
            });
        }
    }
*/
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

