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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.app.DatePickerDialog;
import android.widget.Button;
import java.util.Calendar;

public class ListOfEarthquakes extends Fragment {

    private RecyclerView recyclerView;
    private EarthquakeAdapter adapter;
    private List<EarthquakeResponse.Feature> earthquakes = new ArrayList<>();
    private ProgressBar progressBar;
    private TextView errorTextView;
    private Button startDateButton, endDateButton, searchButton;
    private EditText minMagnitudeInput;

    private String startDate = "";
    private String endDate = "";

    public ListOfEarthquakes() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_of_earthquakes, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


   adapter = new EarthquakeAdapter(earthquakes, earthquake -> {

       //ListOfEarthquakesDirections.ActionListOfEarthquakesToEartquakeInfo action = ListOfEarthquakes.actionListEarthquakesToEartquakeInfo("e");
     //  Navigation.findNavController(view).navigate(action);


       ListOfEarthquakesDirections.ActionListOfEarthquakesToEartquakeInfo action =
               ListOfEarthquakesDirections.actionListOfEarthquakesToEartquakeInfo("e");
       Navigation.findNavController(view).navigate(action);
   });



        recyclerView.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progressBar);
        errorTextView = view.findViewById(R.id.errorTextView);

        startDateButton = view.findViewById(R.id.startDateButton);
        endDateButton = view.findViewById(R.id.endDateButton);
        minMagnitudeInput = view.findViewById(R.id.minMagnitudeInput);
        searchButton = view.findViewById(R.id.searchButton);

        startDateButton.setOnClickListener(v -> showDatePickerDialog((date) -> {
            startDate = date;
            startDateButton.setText("Start Date: " + date);
        }));

        endDateButton.setOnClickListener(v -> showDatePickerDialog((date) -> {
            endDate = date;
            endDateButton.setText("End Date: " + date);
        }));

        searchButton.setOnClickListener(v -> {
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

    private void showDatePickerDialog(DatePickerCallback callback) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, year1, month1, dayOfMonth) -> {
                    String date = String.format("%d-%02d-%02d", year1, month1 + 1, dayOfMonth);
                    callback.onDateSelected(date);
                },
                year, month, day);
        datePickerDialog.show();
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

    interface DatePickerCallback {
        void onDateSelected(String date);
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