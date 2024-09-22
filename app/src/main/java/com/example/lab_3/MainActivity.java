
package com.example.lab_3;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        EditText firstName = findViewById(R.id.firstName);
        EditText lastName = findViewById(R.id.lastName);
        EditText phone = findViewById(R.id.phone);
        TextView error = findViewById(R.id.error);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNameText = firstName.getText().toString().trim();
                String lastNameText = lastName.getText().toString().trim();
                String phoneText = phone.getText().toString().trim();


                if (firstNameText.isEmpty()) {
                    error.setText("Поле 'Имя' не должно быть пустым");
                    error.setVisibility(View.VISIBLE);
                    return;
                }
                if (lastNameText.isEmpty()) {
                    error.setText("Поле 'Фамилия' не должно быть пустым");
                    error.setVisibility(View.VISIBLE);
                    return;
                }
                if (phoneText.isEmpty()) {
                    error.setText("Поле 'Телефон' не должно быть пустым");
                    error.setVisibility(View.VISIBLE);
                    return;
                }
                error.setVisibility(View.INVISIBLE);
             /*   Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("FIRST_NAME", firstNameText);
                intent.putExtra("LAST_NAME", lastNameText);
                intent.putExtra("PHONE", phoneText);
                startActivity(intent); */

                UserData userData = UserData.getInstance();
                userData.setFirstName(firstNameText);
                userData.setLastName(lastNameText);
                userData.setPhone(phoneText);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}

