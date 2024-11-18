package com.example.lab11fix;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelApi {

    @GET("v1/public/events")
    Call<MarvelResponse<Event>> getEvents(
            @Query("limit") int limit,
            @Query("offset") int offset,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/events/{id}")
    Call<MarvelResponse<Event>> getEventById(
            @Path("id") int id,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );
}
