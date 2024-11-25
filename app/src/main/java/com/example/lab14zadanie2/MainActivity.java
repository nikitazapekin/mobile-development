package com.example.lab14zadanie2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private PlayerAdapter adapter;
    private List<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

      RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        players = initializePlayers();
        adapter = new PlayerAdapter(players);
        recyclerView.setAdapter(adapter);



             downloadImages();
    }

 private List<Player> initializePlayers() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(1, "Smith", "https://img.freepik.com/free-psd/macaroon-isolated-transparent-background_191095-42083.jpg?ga=GA1.1.458792085.1728569053&semt=ais_hybrid"));
      //  playerList.add(new Player(2, "Johnson", "https://example.com/image2.jpg"));
        // Добавьте больше игроков с уникальными URL
        return playerList;
    }

    private void downloadImages() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Player player : players) {
            executor.execute(() -> {
                String filePath = ImageDownloader.downloadImage(player.getImageUrl(),
                        getFilesDir() + "/images/" + player.getNumber() + ".jpg");
                player.setFilePath(filePath);
                runOnUiThread(() -> adapter.notifyDataSetChanged());
            });
        }
        executor.shutdown();
    }


}


/*

package com.example.lab14zadanie2;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

*/