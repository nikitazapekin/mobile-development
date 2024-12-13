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

    private TextView idTextView, placeTextView, magnitudeTextView, timeTextView, statusTextView, typeTextView, titleTextView, coordinatesTextView;

    private String id;

    public EarthquakeInfo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Получаем id из аргументов
            id = EarthquakeInfoArgs.fromBundle(getArguments()).getId();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eartquake_info, container, false);

        // Инициализация TextView
        idTextView = view.findViewById(R.id.idTextView);
        placeTextView = view.findViewById(R.id.placeTextView);
        magnitudeTextView = view.findViewById(R.id.magnitudeTextView);
        timeTextView = view.findViewById(R.id.timeTextView);
        statusTextView = view.findViewById(R.id.statusTextView);
        typeTextView = view.findViewById(R.id.typeTextView);
        titleTextView = view.findViewById(R.id.titleTextView);
        coordinatesTextView = view.findViewById(R.id.coordinatesTextView);

        // Запрос данных о землетрясении
        loadEarthquakeDetails(id);

        return view;
    }

    private void loadEarthquakeDetails(String id) {
        // Запрос на получение данных о землетрясении по id
        NetworkService.getInstance()
                .getEarthquakeApi()
                .getEarthquakeDetails(id, "geojson")
                .enqueue(new Callback<Earthquake>() {
                    @Override
                    public void onResponse(Call<Earthquake> call, Response<Earthquake> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Earthquake earthquake = response.body();

                            // Заполняем текстовые поля данными о землетрясении
                            idTextView.setText("ID: " + earthquake.getId());
                            placeTextView.setText("Place: " + earthquake.getPlace());
                            magnitudeTextView.setText("Magnitude: " + earthquake.getMagnitude());
                            timeTextView.setText("Time: " + earthquake.getTime());
                            statusTextView.setText("Status: " + earthquake.getStatus());
                            typeTextView.setText("Type: " + earthquake.getType());
                            titleTextView.setText("Title: " + earthquake.getTitle());

                            // Обработка координат
                            double[] coordinates = earthquake.getCoordinates();
                            if (coordinates != null && coordinates.length >= 3) {
                                coordinatesTextView.setText("Coordinates: Lat: " + coordinates[1] + ", Long: " + coordinates[0] + ", Depth: " + coordinates[2]);
                            } else {
                                coordinatesTextView.setText("Coordinates: Not available");
                            }

                            // Логирование для проверки координат
                            Log.d("EarthquakeInfo", "Coordinates: " + Arrays.toString(coordinates));
                        }
                    }

                    @Override
                    public void onFailure(Call<Earthquake> call, Throwable t) {
                        t.printStackTrace();
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
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeInfo extends Fragment {

    private TextView idTextView, placeTextView, magnitudeTextView, timeTextView, statusTextView, typeTextView, titleTextView, coordinatesTextView;

    private String id;

    public EarthquakeInfo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Получаем id из аргументов
            id = EarthquakeInfoArgs.fromBundle(getArguments()).getId();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eartquake_info, container, false);

        // Инициализация TextView
        idTextView = view.findViewById(R.id.idTextView);
        placeTextView = view.findViewById(R.id.placeTextView);
        magnitudeTextView = view.findViewById(R.id.magnitudeTextView);
        timeTextView = view.findViewById(R.id.timeTextView);
        statusTextView = view.findViewById(R.id.statusTextView);
        typeTextView = view.findViewById(R.id.typeTextView);
        titleTextView = view.findViewById(R.id.titleTextView);
        coordinatesTextView = view.findViewById(R.id.coordinatesTextView);

        // Запрос данных о землетрясении
        loadEarthquakeDetails(id);

        return view;
    }

    private void loadEarthquakeDetails(String id) {
        // Запрос на получение данных о землетрясении по id
        NetworkService.getInstance()
                .getEarthquakeApi()
                .getEarthquakeDetails(id, "geojson")
                .enqueue(new Callback<Earthquake>() {
                    @Override
                    public void onResponse(Call<Earthquake> call, Response<Earthquake> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Earthquake earthquake = response.body();


                            idTextView.setText("ID: " + earthquake.getId()+"");
                            placeTextView.setText("Place: " + earthquake.getPlace()+"");
                            magnitudeTextView.setText("Magnitude: " + earthquake.getMagnitude()+"");
                            timeTextView.setText("Time: " + earthquake.getTime()+"");
                            statusTextView.setText("Status: " + earthquake.getStatus()+"");
                            typeTextView.setText("Type: " + earthquake.getType()+"");
                            titleTextView.setText("Title: " + earthquake.getTitle()+"");

                            // Отображение координат
                            double[] coordinates = earthquake.getCoordinates();
                            coordinatesTextView.setText("Coordinates: Lat: " + coordinates[1] + ", Long: " + coordinates[0] + ", Depth: " + coordinates[2]);
                        }
                    }

                    @Override
                    public void onFailure(Call<Earthquake> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
*/
/*

package com.example.lab11fix;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeInfo extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    private String id;
    public EarthquakeInfo() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            EarthquakeInfoArgs args = EarthquakeInfoArgs.fromBundle(getArguments());
            id = args.getId(); // Получаем ID из Safe Args
            loadEarthquakeDetails(id); // Загружаем данные
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eartquake_info, container, false);
    }



    private void loadEarthquakeDetails(String id) {
        NetworkService.getInstance()
                .getEarthquakeApi()
                .getEarthquakeDetails(id, "geojson")
                .enqueue(new Callback<Earthquake>() {

                    public void onResponse(Call<Earthquake> call, Response<Earthquake> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Earthquake earthquake = response.body();

                            updateUI(earthquake);
                        }
                    }


                    public void onFailure(Call<Earthquake> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    private void updateUI(Earthquake earthquake) {
        // Пример обновления UI
        TextView placeTextView = getView().findViewById(R.id.placeTextView);
        TextView magnitudeTextView = getView().findViewById(R.id.magnitudeTextView);

        placeTextView.setText(earthquake.getPlace());
        magnitudeTextView.setText(String.valueOf(earthquake.getMagnitude()));
    }




}
*/