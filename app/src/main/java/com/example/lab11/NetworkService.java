package com.example.lab11;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService instance;
    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";
    private final Retrofit retrofit;

    private NetworkService() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
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


/*
package com.example.lab11;


public class NetworkService {
}
*/