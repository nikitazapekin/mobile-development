package com.example.lab11fix;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EarthquakeApi {

    @GET("query")
    Call<EarthquakeResponse> getEarthquakes(
            @Query("format") String format,
            @Query("starttime") String startTime,
            @Query("endtime") String endTime,
            @Query("minmagnitude") double minMagnitude
    );
    @GET("query")
    Call<Earthquake> getEarthquakeDetails(
            @Query("eventid") String id,
            @Query("format") String format
    );

}
