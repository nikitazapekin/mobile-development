package com.example.lab11variant22;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService instance;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private final Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (instance == null) {
            instance = new NetworkService();
        }
        return instance;
    }

    public WeatherApi getWeatherApi() {
        return retrofit.create(WeatherApi.class);
    }
}
