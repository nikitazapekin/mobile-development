
package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        // Получаем ссылки на элементы
        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.editTextText);
        errorTextView = findViewById(R.id.textView6); // это поле для отображения ошибки

        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(this::handleRedirect);

        Button selectButton = findViewById(R.id.button);
       // selectButton.setOnClickListener(this::handleValidation);
    }


    public void handleRedirect(View view) {
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
    }


    public void handleValidation(View view) {
        String firstNameText = firstNameEditText.getText().toString().trim();
        String lastNameText = lastNameEditText.getText().toString().trim();

        if (firstNameText.isEmpty()) {
            errorTextView.setText("Поле 'Название' не должно быть пустым");
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }

        if (lastNameText.isEmpty()) {
            errorTextView.setText("Поле 'Адрес' не должно быть пустым");
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }


        errorTextView.setVisibility(View.INVISIBLE);
    }
}


/*

package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);


    }


    public void handleRedirect(View view) {
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
    }








}
*/