
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
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText phone;
    private TextView error;

    private ActivityResultLauncher<Intent> secondActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {


               if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String returnedData = result.getData().getStringExtra("returnedData");
                    Toast.makeText(MainActivity.this, "Received from second activity: " + returnedData, Toast.LENGTH_LONG).show();
                }


            }
    );

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


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("firstName", firstNameText);
                bundle.putString("lastName", lastNameText);
                bundle.putString("phone", phoneText);


                intent.putExtras(bundle);

              secondActivityLauncher.launch(intent);




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
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.lb2");
        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Lab2 app not found", Toast.LENGTH_SHORT).show();
        }
    }
}
