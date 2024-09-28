package com.example.lab_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
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

        // Установка обработчиков кликов программно
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
    }


    public void handleClick(View v) {
        // Определяем элементы View
        View square1 = findViewById(R.id.green_square1);
        View square2 = findViewById(R.id.green_square2);
        View square3 = findViewById(R.id.green_square3);


        square1.setBackgroundResource(R.drawable.neon_gray_square);
        square2.setBackgroundResource(R.drawable.neon_gray_square);
        square3.setBackgroundResource(R.drawable.neon_gray_square);

        int buttonId = v.getId();
        if (buttonId == R.id.button1) {
            Toast.makeText(this, "Нажата кнопка 1 (Желтый)", Toast.LENGTH_SHORT).show();
            square1.setBackgroundResource(R.drawable.neon_red_square); // Установите желтый фон
        } else if (buttonId == R.id.button2) {
            Toast.makeText(this, "Нажата кнопка 2 (Синий)", Toast.LENGTH_SHORT).show();
            square2.setBackgroundResource(R.drawable.neon_yellow_square); // Установите синий фон
        } else if (buttonId == R.id.button3) {
            Toast.makeText(this, "Нажата кнопка 3 (Зеленый)", Toast.LENGTH_SHORT).show();
            square3.setBackgroundResource(R.drawable.neon_green_square); // Установите зеленый фон
        }
    }


}
