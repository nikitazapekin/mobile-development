package com.example.lab11fix;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class ListOfEarthquakes extends Fragment {

    private RecyclerView recyclerView;
    private EarthquakeAdapter adapter;
    private List<EarthquakeResponse.Feature> earthquakes = new ArrayList<>();
    private ProgressBar progressBar;
    private TextView errorTextView;
    private EditText startDateInput, endDateInput, minMagnitudeInput;
    private Button searchButton;

    public ListOfEarthquakes() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_of_earthquakes, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new EarthquakeAdapter(earthquakes);
        recyclerView.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progressBar);
        errorTextView = view.findViewById(R.id.errorTextView);

        startDateInput = view.findViewById(R.id.startDateInput);
        endDateInput = view.findViewById(R.id.endDateInput);
        minMagnitudeInput = view.findViewById(R.id.minMagnitudeInput);
        searchButton = view.findViewById(R.id.searchButton);

        searchButton.setOnClickListener(v -> {
            String startDate = startDateInput.getText().toString();
            String endDate = endDateInput.getText().toString();
            String minMagnitudeStr = minMagnitudeInput.getText().toString();

            if (validateInputs(startDate, endDate, minMagnitudeStr)) {
                double minMagnitude = Double.parseDouble(minMagnitudeStr);
                loadEarthquakes(startDate, endDate, minMagnitude);
            } else {
                errorTextView.setText("Invalid input. Please check your entries.");
                errorTextView.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private boolean validateInputs(String startDate, String endDate, String minMagnitude) {
        return !startDate.isEmpty() && !endDate.isEmpty() && !minMagnitude.isEmpty();
    }

    private void loadEarthquakes(String startDate, String endDate, double minMagnitude) {
        progressBar.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);

        NetworkService.getInstance()
                .getEarthquakeApi()
                .getEarthquakes("geojson", startDate, endDate, minMagnitude)
                .enqueue(new Callback<EarthquakeResponse>() {
                    @Override
                    public void onResponse(Call<EarthquakeResponse> call, Response<EarthquakeResponse> response) {
                        progressBar.setVisibility(View.GONE);
                        if (response.isSuccessful() && response.body() != null) {
                            earthquakes.clear();
                            earthquakes.addAll(response.body().getFeatures());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<EarthquakeResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        t.printStackTrace();
                        errorTextView.setVisibility(View.VISIBLE);
                    }
                });
    }
}

/*
package com.example.lab11fix;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOfEarthquakes extends Fragment {

    private RecyclerView recyclerView;
    private EarthquakeAdapter adapter;
    private List<EarthquakeResponse.Feature> earthquakes = new ArrayList<>();
    private ProgressBar progressBar;
    private TextView errorTextView;

    public ListOfEarthquakes() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_of_earthquakes, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new EarthquakeAdapter(earthquakes);
        recyclerView.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progressBar);
        errorTextView = view.findViewById(R.id.errorTextView);

        loadEarthquakes();

        return view;
    }

    private void loadEarthquakes() {
        progressBar.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);

        NetworkService.getInstance()
                .getEarthquakeApi()
                .getEarthquakes("geojson", "2023-12-01", "2023-12-10", 4.5)
                .enqueue(new Callback<EarthquakeResponse>() {
                    @Override
                    public void onResponse(Call<EarthquakeResponse> call, Response<EarthquakeResponse> response) {
                        progressBar.setVisibility(View.GONE);
                        if (response.isSuccessful() && response.body() != null) {
                            earthquakes.clear();
                            earthquakes.addAll(response.body().getFeatures());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<EarthquakeResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        t.printStackTrace();
                        errorTextView.setVisibility(View.VISIBLE);
                    }
                });
    }
}
*/