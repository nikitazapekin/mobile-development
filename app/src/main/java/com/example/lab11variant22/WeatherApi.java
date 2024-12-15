package com.example.lab11variant22;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("forecast")
    Call<WeatherResponse> getWeatherForecast(
            @Query("q") String city,
            @Query("cnt") int days,
            @Query("appid") String apiKey,
            @Query("units") String units
    );

    @GET("data/2.5/forecast")
    Call<WeatherResponse> getWeatherForecastByCoordinates(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("cnt") int cnt,
            @Query("appid") String apiKey,
            @Query("units") String units
    );
}
