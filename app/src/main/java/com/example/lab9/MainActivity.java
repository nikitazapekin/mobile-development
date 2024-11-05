
package com.example.lab9;

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
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private String color;
    private static final String TAG = "MainActivity";
    public static final String PREFS_FILE = "screenData";
    private static final String COLOR_KEY = "editTextColorText";

    SharedPreferences screenData;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();


        viewModel = new ViewModelProvider(this).get(MyViewModel.class);


        color = viewModel.getCurrentColor();
        applySavedColor(color);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button saveButton = findViewById(R.id.button4);
        Button loadButton = findViewById(R.id.button5);

        button1.setOnClickListener(this::handleClick);
        button2.setOnClickListener(this::handleClick);
        button3.setOnClickListener(this::handleClick);
        saveButton.setOnClickListener(v -> saveSelectedColor(color));
        loadButton.setOnClickListener(v -> applySavedColor(color));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
            Toast.makeText(this, "Нажата кнопка 1 (Красный)", Toast.LENGTH_SHORT).show();
            square1.setBackgroundResource(R.drawable.neon_red_square);
            color = "red";
        } else if (buttonId == R.id.button2) {
            Toast.makeText(this, "Нажата кнопка 2 (Желтый)", Toast.LENGTH_SHORT).show();
            square2.setBackgroundResource(R.drawable.neon_yellow_square);
            color = "yellow";
        } else if (buttonId == R.id.button3) {
            Toast.makeText(this, "Нажата кнопка 3 (Зеленый)", Toast.LENGTH_SHORT).show();
            square3.setBackgroundResource(R.drawable.neon_green_square);
            color = "green";
        }

        if (viewModel != null) {
            viewModel.saveCurrentColor(color);
        } else {
            Log.e(TAG, "viewModel is null");
        }
    }

    private void saveSelectedColor(String color) {
        if (color.isEmpty()) {
            Toast.makeText(this, "Цвет не выбран!", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences.Editor editor = screenData.edit();
        editor.putString(COLOR_KEY, color);
        editor.apply();
        Toast.makeText(this, "Цвет сохранен: " + color, Toast.LENGTH_SHORT).show();
    }

    private void applySavedColor(String color) {
        if (color.isEmpty()) {
            Toast.makeText(this, "Сохраненный цвет отсутствует!", Toast.LENGTH_SHORT).show();
            return;
        }

        View square1 = findViewById(R.id.green_square1);
        View square2 = findViewById(R.id.green_square2);
        View square3 = findViewById(R.id.green_square3);

        square1.setBackgroundResource(R.drawable.neon_gray_square);
        square2.setBackgroundResource(R.drawable.neon_gray_square);
        square3.setBackgroundResource(R.drawable.neon_gray_square);

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
                break;
        }
        Toast.makeText(this, "Загружен цвет: " + color, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    public void handleClose(View v) {
        finish();
    }
}

/*
package com.example.lab9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private String color;
    private static final String TAG = "MainActivity";
    private static final String COLOR_KEY = "editTextColorText";
    public static final String PREFS_FILE = "screenData";

    SharedPreferences screenData;

    private MyViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button saveButton = findViewById(R.id.button4);
        Button loadButton = findViewById(R.id.button5);

        button1.setOnClickListener(this::handleClick);
        button2.setOnClickListener(this::handleClick);
        button3.setOnClickListener(this::handleClick);
        saveButton.setOnClickListener(v -> saveSelectedColor(color));
        loadButton.setOnClickListener(v -> applySavedColor(color));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        screenData = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);


        color = screenData.getString(COLOR_KEY, "");

        if (savedInstanceState != null) {
            color = savedInstanceState.getString(COLOR_KEY, "");
            applySavedColor(color);
        }

        Log.d(TAG, "onCreate");







        MyViewModel  viewModel = new ViewModelProvider(this).get(MyViewModel.class);
    String currentColor  = viewModel.getCurrentColor();
    applySavedColor(currentColor);

        String col = viewModel.loadText();
        if( col!=null) {
           // textView1.setText(text);
            applySavedColor(col);
        }

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
            Toast.makeText(this, "Нажата кнопка 1 (Красный)", Toast.LENGTH_SHORT).show();
            square1.setBackgroundResource(R.drawable.neon_red_square);
            color = "red";
        } else if (buttonId == R.id.button2) {
            Toast.makeText(this, "Нажата кнопка 2 (Желтый)", Toast.LENGTH_SHORT).show();
            square2.setBackgroundResource(R.drawable.neon_yellow_square);
            color = "yellow";
        } else if (buttonId == R.id.button3) {
            Toast.makeText(this, "Нажата кнопка 3 (Зеленый)", Toast.LENGTH_SHORT).show();
            square3.setBackgroundResource(R.drawable.neon_green_square);
            color = "green";
        }
     //   viewModel.saveCurrentColor(color);

        if (viewModel != null) {
            viewModel.saveCurrentColor(color);
        } else {
            Log.e(TAG, "viewModel is null");
        }
    }

    private void saveSelectedColor(String color) {
        if (color.isEmpty()) {
            Toast.makeText(this, "Цвет не выбран!", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences.Editor editor = screenData.edit();
        editor.putString(COLOR_KEY, color);
        editor.apply();
        Toast.makeText(this, "Цвет сохранен: " + color, Toast.LENGTH_SHORT).show();
    }

    private void applySavedColor(String color) {
        if (color.isEmpty()) {
            Toast.makeText(this, "Сохраненный цвет отсутствует!", Toast.LENGTH_SHORT).show();
            return;
        }

        View square1 = findViewById(R.id.green_square1);
        View square2 = findViewById(R.id.green_square2);
        View square3 = findViewById(R.id.green_square3);

        square1.setBackgroundResource(R.drawable.neon_gray_square);
        square2.setBackgroundResource(R.drawable.neon_gray_square);
        square3.setBackgroundResource(R.drawable.neon_gray_square);

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
                break;
        }
        Toast.makeText(this, "Загружен цвет: " + color, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
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

    public void handleClose(View v) {
        finish();
    }
}
*/

/*
package com.example.lab9;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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
import androidx.lifecycle.ViewModelProvider;

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

      //   DataController dataController = DataController.getInstance();
     //   mediatorLiveData.observe(this, new Observer<String>() {
      //              @Override
      //              public void onChanged(@Nullable String s) {
       //                 log("onChanged " + s);
       //             }
         //       }


        DataController dataController = DataController.getInstance();


         dataController.getMediatorLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(TAG, "onChanged: " + s);
            }
        });

        dataController.setData("Hello, World!");






        MyViewModel  viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        String nameText = viewModel.getNameText();
   
        textView.setText(nameText);


        EditText editText  = findViewById(R.id.editTextText);
        Button button  = findViewById(R.id.button);
        TextView textView1 = findViewById(R.id.textView);

        button.setOnClickListener(view-> {
            textView1.setText(editText.getText());

            viewModel.saveText(editText.getText().toString());
        } );


        String text = viewModel.loadText();
         if( text!=null) {
textView1.setText(text);
         }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}
*/