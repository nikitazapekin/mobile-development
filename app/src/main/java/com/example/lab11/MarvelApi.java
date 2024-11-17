package com.example.lab11;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApi {

    @GET("events")
    Call<MarvelResponse> getMarvelEvents(
            @Query("limit") int limit,
            @Query("ts") int ts,
            @Query("apikey") String publicKey,
            @Query("hash") String hash
    );
}
