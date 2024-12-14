package com.example.lab11fix;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Arrays;

public class EarthquakeInfo extends Fragment {

    private TextView idTextView, placeTextView, magnitudeTextView, timeTextView, statusTextView,

    titleTextView ;

    private String id;

    public EarthquakeInfo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            id = EarthquakeInfoArgs.fromBundle(getArguments()).getId();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eartquake_info, container, false);


           magnitudeTextView = view.findViewById(R.id.magnitudeTextView);
        placeTextView = view.findViewById(R.id.placeTextView);
        timeTextView = view.findViewById(R.id.timeTextView);
        statusTextView = view.findViewById(R.id.statusTextView);
        titleTextView = view.findViewById(R.id.titleTextView);

       idTextView = view.findViewById(R.id.idTextView);

        loadEarthquakeDetails(id);

        return view;
    }

    private void loadEarthquakeDetails(String id) {

        NetworkService.getInstance()
                .getEarthquakeApi()
                .getEarthquakeDetails(id, "geojson")
                .enqueue(new Callback<Earthquake>() {
                    @Override
                    public void onResponse(Call<Earthquake> call, Response<Earthquake> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Earthquake earthquake = response.body();




                            Earthquake.Properties props = earthquake.getProperties();
                            if (props != null) {
                                 magnitudeTextView.setText("Magnitude: " + props.getMag());
idTextView.setText("ID: "+ earthquake.getId());
                                placeTextView.setText("Place: " + props.getPlace());
                         timeTextView.setText("Time: " + props.getTime());

                                statusTextView.setText("Status: " + props.getStatus());
                                titleTextView.setText("Title: " + props.getTitle());



                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<Earthquake> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}

