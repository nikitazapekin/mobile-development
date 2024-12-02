package com.example.lb14;


import android.graphics.Bitmap;

public class Movie {
    private int number;
    private String title;
    private String imageUrl;
    private Bitmap bitmap;

    public Movie(int number, String title, String imageUrl) {
        this.number = number;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}