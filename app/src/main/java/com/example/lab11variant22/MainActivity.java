package com.example.lab11variant22;

import android.os.Bundle;
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
        fetchWeather("Minsk");

        // Weather search button click listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = cityEditText.getText().toString().trim();
                if (city.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
                } else {
                    fetchWeather(city);
                }
            }
        });

        // Coordinates search button click listener
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

    // Fetch coordinates data from OpenCage API using OpenCageNetworkService
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

/*
package com.example.lab11variant22;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "2809d4b75eff6a4e61268fcb7893a2ea";
    private WeatherAdapter adapter;
    private EditText cityEditText;  // Reference to the EditText
    private Button searchButton;    // Reference to the Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditText and Button
        cityEditText = findViewById(R.id.cityEditText);
        searchButton = findViewById(R.id.searchButton);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WeatherAdapter();
        recyclerView.setAdapter(adapter);

        // Set default weather data (for Minsk)
        fetchWeather("Minsk");

        // Set the search button click listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = cityEditText.getText().toString().trim();
                if (city.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
                } else {
                    fetchWeather(city); // Fetch weather for the entered city
                }
            }
        });
    }

    // Fetch weather data for the city
    private void fetchWeather(String city) {
        NetworkService.getInstance()
                .getWeatherApi()
                .getWeatherForecast(city, 16, API_KEY, "metric")
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
}
*/
/*
package com.example.lab11variant22;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "2809d4b75eff6a4e61268fcb7893a2ea";
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WeatherAdapter();
        recyclerView.setAdapter(adapter);

        fetchWeather("Minsk"); // Default weather data for Minsk
    }

    // Handle menu item selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String city = null;
        int itemId = item.getItemId();
        String type = null;
        if (itemId == R.id.minsk) {
            type = "minsk";
        } else if (itemId == R.id.mogilev) {
            type = "mogilev";
        } else if (itemId == R.id.grodno) {
            type = "grodno";
        } else if (itemId == R.id.gomel) {
            type = "gomel";
        } else if (itemId == R.id.brest) {
            type = "brest";
        }
        else if (itemId == R.id.vitebsk) {
            type = "vitebsk";
        }
        else {
            return false;
        }

        Toast.makeText(this, "Fetching weather for: " + city, Toast.LENGTH_SHORT).show();

        // Fetch weather data for the selected city
        fetchWeather(type);

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    private void fetchWeather(String city) {
        NetworkService.getInstance()
                .getWeatherApi()
                .getWeatherForecast(city, 16, API_KEY, "metric")
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
}
*/