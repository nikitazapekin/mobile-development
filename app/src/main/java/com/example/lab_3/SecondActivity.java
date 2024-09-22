package com.example.lab_3;

import android.content.Intent; // Добавьте этот импорт
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        // Получаем Intent
        Intent intent = getIntent();  // Этот метод извлекает Intent, который запустил активность

        // Извлекаем данные из Intent
        String firstName = intent.getStringExtra("FIRST_NAME");
        String lastName = intent.getStringExtra("LAST_NAME");
        String phone = intent.getStringExtra("PHONE");

        // Найдем TextView и установим текст
        TextView textView = findViewById(R.id.textView);
        textView.setText("Имя: " + firstName + "\nФамилия: " + lastName + "\nТелефон: " + phone);
    }
}


/*
package com.example.lab_3;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        // Получаем Intent
        Intent intent = getIntent();

        // Извлекаем данные из Intent
        String firstName = intent.getStringExtra("FIRST_NAME");
        String lastName = intent.getStringExtra("LAST_NAME");
        String phone = intent.getStringExtra("PHONE");

        // Найдем TextView и установим текст
        TextView textView = findViewById(R.id.textView);
        textView.setText("Имя: " + firstName + "\nФамилия: " + lastName + "\nТелефон: " + phone);
    }
}
*/

/*
package com.example.lab_3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }
}
*/
