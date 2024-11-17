
package com.example.lab11;



import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MarvelEventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MarvelRepository marvelRepository = new MarvelRepository();
        marvelRepository.fetchMarvelEvents(new MarvelRepository.MarvelCallback() {
            @Override
            public void onDataFetched(MarvelResponse response) {
                // Pass the fetched data to the adapter
                List<MarvelResponse.Event> events = response.getData().getEvents();
                adapter = new MarvelEventAdapter(events);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {
                Log.e("MainActivity", "Error fetching data: " + error);
            }
        });
    }
}
/*
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        MarvelRepository marvelRepository = new MarvelRepository();
        marvelRepository.fetchMarvelEvents();    }
}

 */

