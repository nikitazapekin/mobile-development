package com.example.lab11fix;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

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



    @GET("v1/public/events/{eventId}/characters")
    Call<MarvelResponse<MarvelItem>> getEventCharacters(
            @Path("eventId") int eventId,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/events/{eventId}/comics")
    Call<MarvelResponse<MarvelItem>> getEventComics(
            @Path("eventId") int eventId,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/events/{eventId}/creators")
    Call<MarvelResponse<MarvelItem>> getEventCreators(
            @Path("eventId") int eventId,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/events/{eventId}/series")
    Call<MarvelResponse<MarvelItem>> getEventSeries(
            @Path("eventId") int eventId,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/events/{eventId}/stories")
    Call<MarvelResponse<MarvelItem>> getEventStories(
            @Path("eventId") int eventId,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );


    @GET
    Call<MarvelResponse<Character>> getCharacterByResourceUri(
            @Url String resourceUri,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );


}
