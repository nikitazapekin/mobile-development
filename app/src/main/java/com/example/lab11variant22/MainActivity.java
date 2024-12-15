

package com.example.lab11variant22;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY_WEATHER = "2809d4b75eff6a4e61268fcb7893a2ea";
    private static final String API_KEY_COORDINATES = "292163463cd642c9adeff45a7d3c6ab9";  // OpenCage API key
    private WeatherAdapter adapter;
    private EditText cityEditText;  // City input for weather
    private EditText coordinateCityEditText;  // City input for coordinates
    private Button searchButton;    // Weather search button
    private Button searchCoordinatesButton;  // Coordinates search button
    private TextView coordinatesTextView;  // TextView to display coordinates

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        cityEditText = findViewById(R.id.cityEditText);
        coordinateCityEditText = findViewById(R.id.coordinateCityEditText);
        searchButton = findViewById(R.id.searchButton);
        searchCoordinatesButton = findViewById(R.id.searchCoordinatesButton);
        coordinatesTextView = findViewById(R.id.coordinatesTextView);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WeatherAdapter();
        recyclerView.setAdapter(adapter);

        // Set default weather data (for Minsk)
        //    fetchWeather("Minsk");
fetchWeatherByCoordinates(53.9, 27.5667);










        // Weather search button click listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = cityEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(input)) {
                    if (input.contains(" ")) {
                        // If input contains space, assume it's coordinates
                        String[] coordinates = input.split(" ");
                        Log.d("d", input);
                        if (coordinates.length == 2) {
                            try {
                                double latitude = Double.parseDouble(coordinates[0]);
                                double longitude = Double.parseDouble(coordinates[1]);
                                Log.d("Coordinates", "Latitude: " + coordinates[0] + ", Longitude: " + coordinates[1]);

                                fetchWeatherByCoordinates(latitude, longitude); // Ensure this method is called correctly
                            } catch (NumberFormatException e) {
                                Toast.makeText(MainActivity.this, "Invalid coordinates", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter valid coordinates", Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        fetchWeather(input);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a city or coordinates", Toast.LENGTH_SHORT).show();
                }
            }
        });


        searchCoordinatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            String city = coordinateCityEditText.getText().toString().trim();
                if (city.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a city name for coordinates", Toast.LENGTH_SHORT).show();
                } else {
                    fetchCoordinates(city);
                }


            }
        });
    }

    // Fetch weather data
    private void fetchWeather(String city) {
        NetworkService.getInstance()
                .getWeatherApi()
                .getWeatherForecast(city, 16, API_KEY_WEATHER, "metric")
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            adapter.setWeatherList(response.body().getWeatherList());
                        } else {
                            Log.e("WeatherApp", "Response unsuccessful or empty body");
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        Log.e("WeatherApp", "Error fetching weather", t);
                    }
                });
    }

    private void fetchWeatherByCoordinates(double latitude, double longitude) {
        Log.d("cord", "Response body: " + latitude+" "+longitude);
        NetworkService.getInstance()
                .getWeatherApi()
                .getWeatherForecastByCoordinates(latitude, longitude, 16, API_KEY_WEATHER, "metric")
                .enqueue(new Callback<WeatherResponse>() {
                       @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("WeatherApp", "Response body: " + response.body().toString());
                            adapter.setWeatherList(response.body().getWeatherList());
                        } else {
                            Log.e("WeatherApp", "Response unsuccessful or empty body");
                        }
                    }




                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        Log.e("WeatherApp", "Error fetching weather", t);
                    }
                });
    }

    private void fetchCoordinates(String city) {
        Call<CoordinatesResponse> call = OpenCageNetworkService.getInstance()
                .getOpenCageApi()
                .getCoordinates(city, API_KEY_COORDINATES);

        call.enqueue(new Callback<CoordinatesResponse>() {
            @Override
            public void onResponse(Call<CoordinatesResponse> call, Response<CoordinatesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    double lat = response.body().getResults().get(0).getGeometry().getLat();
                    double lng = response.body().getResults().get(0).getGeometry().getLng();
                    coordinatesTextView.setText("Latitude: " + lat + "\nLongitude: " + lng);
                } else {
                    Log.e("CoordinatesApp", "Error fetching coordinates");
                }
            }

            @Override
            public void onFailure(Call<CoordinatesResponse> call, Throwable t) {
                Log.e("CoordinatesApp", "Error fetching coordinates", t);
            }
        });
    }
}
