package com.example.lab9;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import android.util.Log;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new MyServer(this));


        if (getLifecycle() .getCurrentState() == Lifecycle.State.RESUMED) {


        }
        if (getLifecycle() .getCurrentState() .isAtLeast (Lifecycle.State.STARTED)) {


        }

        textView = findViewById(R.id.test);


        DataController.getInstance().setData("123");
   LiveData<String> liveData = DataController.getInstance().getData() ;

        liveData.observe (this, new Observer<String>() {

            public void onChanged(@Nullable String value) {
                textView.setText(value);
            }
        });

        /* DataController dataController = DataController.getInstance();
        mediatorLiveData.observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        log("onChanged " + s);
                    }
                }
*/

        DataController dataController = DataController.getInstance();

        // Наблюдение за mediatorLiveData
         dataController.getMediatorLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(TAG, "onChanged: " + s);
            }
        });

        // Пример обновления данных
        dataController.setData("Hello, World!");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}
