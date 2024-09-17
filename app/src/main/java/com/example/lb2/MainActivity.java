package com.example.lb2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

import android.graphics.Color;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.content.ContextCompat;
public class MainActivity extends AppCompatActivity {
    private Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public int generateRandomNumber() {
        return random.nextInt(10) + 1;
    }

    public void handleClick(View view) {
        int random = generateRandomNumber();
      //  Toast.makeText(this, "Random: " + random, Toast.LENGTH_SHORT).show();
        EditText numberInput = findViewById(R.id.numberInput);
        TextView errorTextView = findViewById(R.id.error);

        String inputText = numberInput.getText().toString();
        String randomText = String.valueOf(random);
        errorTextView.setVisibility(View.VISIBLE);
        if (inputText.isEmpty()) {
          errorTextView.setText("Пожалуйста введите значение в форму");
            errorTextView.setTextColor(Color.parseColor("#FF0000"));
        } else if (inputText.equals(randomText)) {
            errorTextView.setText("Поздравляем! Вы угадали число");
            errorTextView.setTextColor(Color.parseColor("#008000"));


        } else {
            errorTextView.setText("Неверно. Заданное число: " + random);
            errorTextView.setTextColor(Color.parseColor("#FF0000"));
        }
    }

}

