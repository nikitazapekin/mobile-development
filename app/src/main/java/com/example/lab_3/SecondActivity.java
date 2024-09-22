package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        UserData userData = UserData.getInstance();

        String firstName = userData.getFirstName();
        String lastName = userData.getLastName();
        String phone = userData.getPhone();

        String fromName = userData.getFromName();
        String fromAdress = userData.getFromAdress();
        String toName = userData.getToName();
        String toAdress = userData.getToAdress();
        TextView textView = findViewById(R.id.textView);
        textView.setText("Имя: " + firstName + "\nФамилия: " + lastName + "\nТелефон: " + phone+ "\n From " + fromName);
    }





public void handleRedirect(View view) {
    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
    startActivity(intent);
}



}
