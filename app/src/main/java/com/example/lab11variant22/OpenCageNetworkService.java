package com.example.lab11variant22;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenCageNetworkService {

    private static final String BASE_URL = "https://api.opencagedata.com/";

    private static OpenCageNetworkService instance;
    private OpenCageApi openCageApi;

    // Private constructor to prevent instantiation
    private OpenCageNetworkService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        openCageApi = retrofit.create(OpenCageApi.class);
    }


    public static synchronized OpenCageNetworkService getInstance() {
        if (instance == null) {
            instance = new OpenCageNetworkService();
        }
        return instance;
    }

    public OpenCageApi getOpenCageApi() {
        return openCageApi;
    }
}
