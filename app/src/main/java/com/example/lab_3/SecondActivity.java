package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("FIRST_NAME");
        String lastName = intent.getStringExtra("LAST_NAME");
        String phone = intent.getStringExtra("PHONE");
        TextView textView = findViewById(R.id.textView);
        textView.setText("Имя: " + firstName + "\nФамилия: " + lastName + "\nТелефон: " + phone);
    }
}

