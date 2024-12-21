package com.example.lab11new;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab11new.NetworkService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String selectedDate = "";
    private RecyclerView recyclerView;
    private SunriseSunsetAdapter adapter;
    private List<SunriseSunsetAdapter.Item> items = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button datePickerButton = findViewById(R.id.datePickerButton);
        Button searchButton = findViewById(R.id.searchButton);
        EditText longitudeInput = findViewById(R.id.longitudeInput);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SunriseSunsetAdapter(items);
        recyclerView.setAdapter(adapter);


        datePickerButton.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
                selectedDate = year1 + "-" + (month1 + 1) + "-" + dayOfMonth;
                datePickerButton.setText(selectedDate);
            }, year, month, day).show();
        });


        searchButton.setOnClickListener(v -> {
            String longitudeStr = longitudeInput.getText().toString();
            if (!selectedDate.isEmpty() && !longitudeStr.isEmpty()) {
                try {
                    double longitude = Double.parseDouble(longitudeStr);
                    fetchSunriseSunset(longitude);
                } catch (NumberFormatException e) {
                    longitudeInput.setError("Введите корректное число");
                }
            } else {
                if (selectedDate.isEmpty()) {
                    datePickerButton.setError("Выберите дату");
                }
                if (longitudeStr.isEmpty()) {
                    longitudeInput.setError("Введите долготу");
                }
            }
        });
    }



    private void fetchSunriseSunset(double longitude) {
        items.clear();
        for (double latitude = -90; latitude <= 90; latitude += 10) {
            double finalLatitude = latitude;
            NetworkService.getInstance().getSunriseApi().getSunriseSunset(latitude, longitude, selectedDate)
                    .enqueue(new Callback<SunriseResponse>() {
                        @Override
                        public void onResponse(Call<SunriseResponse> call, Response<SunriseResponse> response) {
                            if (response.body() != null) {
                                items.add(new SunriseSunsetAdapter.Item(finalLatitude,
                                        response.body().getResults().getSunrise(),
                                        response.body().getResults().getSunset()));
                                adapter.notifyDataSetChanged();
                            }
                        }


                        public void onFailure(Call<SunriseResponse> call, Throwable t) {

                        }


                    });
        }








}
}
