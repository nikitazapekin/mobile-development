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
           magnitudeTextView = view.findViewById(R.id.magnitudeTextView);
        placeTextView = view.findViewById(R.id.placeTextView);
        timeTextView = view.findViewById(R.id.timeTextView);
        statusTextView = view.findViewById(R.id.statusTextView);
        titleTextView = view.findViewById(R.id.titleTextView);
        //       alertTextView = view.findViewById(R.id.alertTextView);
        //   cdiTextView = view.findViewById(R.id.cdiTextView);
        //   mmiTextView = view.findViewById(R.id.mmiTextView);


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




                            Earthquake.Properties props = earthquake.getProperties();
                            if (props != null) {
                                 magnitudeTextView.setText("Magnitude: " + props.getMag());
                                //  magTextView.setText("Magnitude: " + earthquake.getProperties());
                                placeTextView.setText("Place: " + props.getAlert());
                                //     timeTextView.setText("Time: " + props.getTime());
                                //       magTextView.setText("Magnitude: " + earthquake.getProperties().getTime());
                                statusTextView.setText("Status: " + props.getStatus());
                                titleTextView.setText("Title: " + props.getTitle());
                                //     alertTextView.setText("Alert: " + props.getAlert());
                                //    cdiTextView.setText("CDI: " + (props.getCdi() != null ? props.getCdi() : "N/A"));
                                //    mmiTextView.setText("MMI: " + (props.getMmi() != null ? props.getMmi() : "N/A"));

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


/*
package com.example.lab11fix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.InputStream;

public class EarthquakeInfo extends Fragment {

    private TextView magTextView, placeTextView, timeTextView, statusTextView, titleTextView, alertTextView, cdiTextView, mmiTextView;
    private ImageView earthquakeImageView;  // ImageView for the earthquake image
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     //   magTextView = view.findViewById(R.id.magTextView);
        placeTextView = view.findViewById(R.id.placeTextView);
        timeTextView = view.findViewById(R.id.timeTextView);
        statusTextView = view.findViewById(R.id.statusTextView);
        titleTextView = view.findViewById(R.id.titleTextView);
 //       alertTextView = view.findViewById(R.id.alertTextView);
     //   cdiTextView = view.findViewById(R.id.cdiTextView);
     //   mmiTextView = view.findViewById(R.id.mmiTextView);

        loadEarthquakeDetails(id);
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
                             //  magTextView.setText("Magnitude: " + props.getMag());
                              //  magTextView.setText("Magnitude: " + earthquake.getProperties());
                                placeTextView.setText("Place: " + props.getAlert());
                           //     timeTextView.setText("Time: " + props.getTime());
                         //       magTextView.setText("Magnitude: " + earthquake.getProperties().getTime());
                                statusTextView.setText("Status: " + props.getStatus());
                                titleTextView.setText("Title: " + props.getTitle());
                           //     alertTextView.setText("Alert: " + props.getAlert());
                         //    cdiTextView.setText("CDI: " + (props.getCdi() != null ? props.getCdi() : "N/A"));
                         //    mmiTextView.setText("MMI: " + (props.getMmi() != null ? props.getMmi() : "N/A"));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Earthquake> call, Throwable t) {
                        Log.e("EarthquakeInfo", "Failed to load earthquake details", t);
                    }
                });
    }




}
*/
/*
    private void loadEarthquakeImage(String imageUrl) {
        NetworkService.getInstance()
                .getEarthquakeApi()
              //  .getEarthquakeImage(imageUrl)  // Assuming you have a method to fetch image
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            try {
                                InputStream inputStream = response.body().byteStream();
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                earthquakeImageView.setImageBitmap(bitmap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

 */
/*
package com.example.lab11fix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.InputStream;
import java.util.Arrays;
public class EarthquakeInfo extends Fragment {

    private TextView idTextView, placeTextView, magnitudeTextView, timeTextView, statusTextView, typeTextView, titleTextView, coordinatesTextView;
    private ImageView earthquakeImageView;  // ImageView for the earthquake image
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

        // Initialize TextViews
        idTextView = view.findViewById(R.id.idTextView);
        placeTextView = view.findViewById(R.id.placeTextView);
        magnitudeTextView = view.findViewById(R.id.magnitudeTextView);
        timeTextView = view.findViewById(R.id.timeTextView);
        statusTextView = view.findViewById(R.id.statusTextView);
        typeTextView = view.findViewById(R.id.typeTextView);
        titleTextView = view.findViewById(R.id.titleTextView);
        coordinatesTextView = view.findViewById(R.id.coordinatesTextView);
        earthquakeImageView = view.findViewById(R.id.earthquakeImageView);

        // Load earthquake details
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

                            // Fill the TextViews with earthquake data
                             idTextView.setText("ID: " + earthquake.getId());
                            placeTextView.setText("Place: " + earthquake.getPlace());
                            magnitudeTextView.setText("Magnitude: " + earthquake.getMagnitude());
                            timeTextView.setText("Time: " + earthquake.getTime());
                            statusTextView.setText("Status: " + earthquake.getStatus());
                            typeTextView.setText("Type: " + earthquake.getType());
                           titleTextView.setText("Title: " + earthquake.getTitle());



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