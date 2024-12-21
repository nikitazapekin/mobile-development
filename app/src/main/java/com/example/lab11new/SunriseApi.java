package com.example.lab11new;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SunriseApi {
    @GET("json")
    Call<SunriseResponse> getSunriseSunset(
            @Query("lat") double latitude,
            @Query("lng") double longitude,
            @Query("date") String date
    );
}
