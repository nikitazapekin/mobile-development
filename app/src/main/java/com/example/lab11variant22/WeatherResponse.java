package com.example.lab11variant22;



import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("list")
    private List<WeatherItem> weatherList;

    public List<WeatherItem> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<WeatherItem> weatherList) {
        this.weatherList = weatherList;
    }
}
