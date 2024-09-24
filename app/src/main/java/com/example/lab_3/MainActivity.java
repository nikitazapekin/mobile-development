package com.example.lab_3;
import android.content.pm.PackageManager;
import android.widget.Toast;
import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText phone;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phone = findViewById(R.id.phone);
        error = findViewById(R.id.error);

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
                UserData userData = UserData.getInstance();
                userData.setFirstName(firstNameText);
                userData.setLastName(lastNameText);
                userData.setPhone(phoneText);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void handleCall(View v) {
        String phoneText = phone.getText().toString().trim();

        if (!phoneText.isEmpty()) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneText));
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                startActivity(callIntent);
            }
        } else {
            error.setText("Введите номер телефона для звонка");
            error.setVisibility(View.VISIBLE);
        }
    }








    public void launchLab2App(View view) {
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.lb2"); // Replace with actual Lab2 package name
        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Lab2 app not found", Toast.LENGTH_SHORT).show();
        }
    }

}

