package com.example.lab11fix;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {

    @GET("planetary/apod")
    Call<List<NasaImage>> getRandomImages(
            @Query("count") int count,
            @Query("api_key") String apiKey
    );


    @GET("planetary/apod")
    Call<NasaImage> getImageOfTheDay(
            @Query("api_key") String apiKey
    );
}
