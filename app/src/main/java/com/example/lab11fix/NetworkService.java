package com.example.lab11fix;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService instance;
    private static final String BASE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
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

    public EarthquakeApi getEarthquakeApi() {
        return retrofit.create(EarthquakeApi.class);
    }
}

/*
package com.example.lab11fix;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService instance;
    private static final String BASE_URL = "https://gateway.marvel.com/";
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

    public MarvelApi getMarvelApi() {
        return retrofit.create(MarvelApi.class);
    }
}
*/