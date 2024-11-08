package com.example.lab10;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();
                        if (post != null) {
                       //     textView.append("ID -> " + post.getId() + "\n");
                            textView.append("UserID -> " + post.getUserId() + "\n");
                       //     textView.append("Title -> " + post.getTitle() + "\n");
                         //   textView.append("Body -> " + post.getBody() + "\n");
                        } else {
                            textView.append("Response is empty\n");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                        textView.append("Error occurred while getting request!\n");
                        t.printStackTrace();
                    }
                });
    }
}

/*
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

 package com.example.lab10;






 class MainActivity extends AppCompatActivity {
    verride
    otected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedIns tanceState) ;
        setContentView(R. layout. activity_main);
        TextView textView = findViewById(R. id. textView) ;
        NetworkService.getInstance() NetworkService
»getJSONApi() JSONPlaceHolderApi
                .getPostWithID(1) Call<Post>
        -enqueue(new Callback<Post>() {
            @0verride
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> r

Post post = response.body();
            Z. sexcvien append ->" + post.getId() + "\n");

            Co3ganca tex tView. append("UserID + post.getUserId() + "\n");
            o6bext! textView.append("Title ->" + post.getTitle() + "\n");
textView.append("Body ->" + post.getBody() + "\n");
        }
        @0verride

        public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
            textView.append("Error occurred while getting request!");
            t.printStackTrace();

            yi:
*/
/*
package com.example.lab10;

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