package com.example.lb14;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<Movie> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        players = createPlayerList();
        adapter = new MovieAdapter(players);
        recyclerView.setAdapter(adapter);

        ImageLoaderThread imageLoaderThread = new ImageLoaderThread(players, adapter);
        imageLoaderThread.start();
    }

    private List<Movie> createPlayerList() {
        return Arrays.asList(

          new Movie(1, "The alien", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzl-d9goGvi7qCy9TLA_iXatDVgZRQK5_qCg&s"),
        new Movie(2, "Fighter", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRe0Kewkm8M20YqNiwFlZOYUejlagyXplneeqCtI8sCN5blD-71SiEVBHhAGzKWE8umqxk&usqp=CAU"),
        new Movie(3, "Game changer", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfwsYyO3Zk9nLFBfNI5kqqpSNDywS-UwSGng&s"),
                new Movie(4, "Dispekable me", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmKL_VOzVVRu1HjpLCEtVZ-KGahPdFWLk1Vg&s"),

        new Movie(5, "Minions", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkwVWjvDCxGA6kz9PY3Mn_4PDO-wVwj6SmNQajwkC6Ou0uDNDFNhvgzf8KZNdxys__6kY&usqp=CAU"),
                new Movie(7, "Shift", "https://images.angelstudios.com/image/upload/q_auto,w_294,h_441,f_webp,c_scale/v1728016182/studio-app/catalog/c6b24114-08f2-4b8e-bf5e-a2b76b1c4662"),
                new Movie(8, "Chaos", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0d8zT5qAKQ-6ewrR3lQrwhJD5UX3HjtCl1FBP7YdWBmuvQFfk31JQkOM_doR6yJb7fOE&usqp=CAU"),
                new Movie(9, "Ends", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiYaDmm1YdhKwRS2ocivB0Nnq_GjOvZw1AsfM67od23Ik84YDz49sqBtiTsb4OycJ1u1U&usqp=CAU"),
                new Movie(10, "Wicked", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTk-f_9Qz-9dplm1zDKPxgsUALxYIHC7PLMag&s")
        );
    }
}