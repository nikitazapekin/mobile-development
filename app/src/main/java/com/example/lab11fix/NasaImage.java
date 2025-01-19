package com.example.lab11fix;

import com.google.gson.annotations.SerializedName;

public class NasaImage {
    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("explanation")
    private String explanation;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getExplanation() {
        return explanation;
    }
}
