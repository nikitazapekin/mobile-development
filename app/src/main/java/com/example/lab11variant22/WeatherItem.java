package com.example.lab11variant22;


import com.google.gson.annotations.SerializedName;

public class WeatherItem {

    @SerializedName("dt_txt")
    private String date;

    @SerializedName("main")
    private Main main;

    @SerializedName("weather")
    private Weather[] weather;

    public String getDate() {
        return date;
    }

    public Main getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }
}


