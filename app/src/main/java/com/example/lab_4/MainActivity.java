
package com.example.lab_4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String color;
    private static final String TAG = "MainActivity";
    private static final String COLOR_KEY = "editTextColorText";
    public static final String PREFS_FILE = "screenData";

    SharedPreferences screenData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this::handleClick);
        button2.setOnClickListener(this::handleClick);
        button3.setOnClickListener(this::handleClick);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve saved color
        screenData = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        color = screenData.getString(COLOR_KEY, "");
        applySavedColor(color);

        if (savedInstanceState != null) {
            Toast.makeText(this, savedInstanceState.getString(COLOR_KEY, ""), Toast.LENGTH_SHORT).show();
        }

        Log.d(TAG, "onCreate");
    }

    public void handleClick(View v) {
        View square1 = findViewById(R.id.green_square1);
        View square2 = findViewById(R.id.green_square2);
        View square3 = findViewById(R.id.green_square3);

        square1.setBackgroundResource(R.drawable.neon_gray_square);
        square2.setBackgroundResource(R.drawable.neon_gray_square);
        square3.setBackgroundResource(R.drawable.neon_gray_square);

        int buttonId = v.getId();
        if (buttonId == R.id.button1) {
            Toast.makeText(this, "Нажата кнопка 1 (Желтый)", Toast.LENGTH_SHORT).show();
            square1.setBackgroundResource(R.drawable.neon_red_square);
            saveSelectedColor("red");
        } else if (buttonId == R.id.button2) {
            Toast.makeText(this, "Нажата кнопка 2 (Синий)", Toast.LENGTH_SHORT).show();
            square2.setBackgroundResource(R.drawable.neon_yellow_square);
            saveSelectedColor("yellow");
        } else if (buttonId == R.id.button3) {
            Toast.makeText(this, "Нажата кнопка 3 (Зеленый)", Toast.LENGTH_SHORT).show();
            square3.setBackgroundResource(R.drawable.neon_green_square);
            saveSelectedColor("green");
        }
    }

    private void saveSelectedColor(String color) {
        SharedPreferences.Editor editor = screenData.edit();
        editor.putString(COLOR_KEY, color);
        editor.apply();
    }

    private void applySavedColor(String color) {
        View square1 = findViewById(R.id.green_square1);
        View square2 = findViewById(R.id.green_square2);
        View square3 = findViewById(R.id.green_square3);

        switch (color) {
            case "red":
                square1.setBackgroundResource(R.drawable.neon_red_square);
                break;
            case "yellow":
                square2.setBackgroundResource(R.drawable.neon_yellow_square);
                break;
            case "green":
                square3.setBackgroundResource(R.drawable.neon_green_square);
                break;
            default:
                // No saved color
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(COLOR_KEY, color);
    }
}

/*
package com.example.lab_4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private String color;
    private static final String TAG = "MainActivity";


    private static final String COLOR_KEY = "editTextColorText";
 //   private static final String TEXT_VIEW_RESULT_KEY = "textViewResultText";
    public static final String PREFS_FILE = "screenData";

    SharedPreferences screenData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this::handleClick);
        button2.setOnClickListener(this::handleClick);
        button3.setOnClickListener(this::handleClick);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        if (savedInstanceState != null) {

            Toast.makeText(this, savedInstanceState.getString(COLOR_KEY, ""), Toast.LENGTH_SHORT).show();
        }



        screenData = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        Log.d(TAG, "onCreate");
    }

    public void handleClick(View v) {
        View square1 = findViewById(R.id.green_square1);
        View square2 = findViewById(R.id.green_square2);
        View square3 = findViewById(R.id.green_square3);

        square1.setBackgroundResource(R.drawable.neon_gray_square);
        square2.setBackgroundResource(R.drawable.neon_gray_square);
        square3.setBackgroundResource(R.drawable.neon_gray_square);

        int buttonId = v.getId();
        if (buttonId == R.id.button1) {
            Toast.makeText(this, "Нажата кнопка 1 (Желтый)", Toast.LENGTH_SHORT).show();
            square1.setBackgroundResource(R.drawable.neon_red_square);
        } else if (buttonId == R.id.button2) {
            Toast.makeText(this, "Нажата кнопка 2 (Синий)", Toast.LENGTH_SHORT).show();
            square2.setBackgroundResource(R.drawable.neon_yellow_square);
        } else if (buttonId == R.id.button3) {
            Toast.makeText(this, "Нажата кнопка 3 (Зеленый)", Toast.LENGTH_SHORT).show();
            square3.setBackgroundResource(R.drawable.neon_green_square);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }
}
*/