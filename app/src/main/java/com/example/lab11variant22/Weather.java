package com.example.lab11variant22;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("description")
    private String description;

    public String getDescription() {
        return description;
    }
}