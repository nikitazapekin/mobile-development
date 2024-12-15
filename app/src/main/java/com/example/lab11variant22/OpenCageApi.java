package com.example.lab11variant22;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenCageApi {
    @GET("geocode/v1/json")
    Call<CoordinatesResponse> getCoordinates(@Query("q") String city, @Query("key") String apiKey);
}
