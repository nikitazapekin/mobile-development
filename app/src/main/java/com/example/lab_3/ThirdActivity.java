
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
    private EditText toNameInput;
    private EditText toAdressInput;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);


        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.editTextText);
        toNameInput =  findViewById(R.id.toNameInput);
        toAdressInput = findViewById(R.id.toAdressName);
        errorTextView = findViewById(R.id.textView6);

        //   Button backButton = findViewById(R.id.back);
    //    backButton.setOnClickListener(this::handleRedirect);


    }


    public void handleRedirect(View view) {
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
    }


    public void handleValidation(View view) {
        String firstNameText = firstNameEditText.getText().toString().trim();
        String lastNameText = lastNameEditText.getText().toString().trim();


        String toNameInputValue = toNameInput.getText().toString().trim();
        String  toAdressInputValue = toAdressInput.getText().toString().trim();
        if (firstNameText.isEmpty()) {
            errorTextView.setText("Поле 'Название (Откуда)' не должно быть пустым");
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }

        if (lastNameText.isEmpty()) {
            errorTextView.setText("Поле 'Адрес (Откуда)' не должно быть пустым");
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }

        if (toNameInputValue.isEmpty()) {
            errorTextView.setText("Поле 'Название (Куда)' не должно быть пустым");
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }
        if (toAdressInputValue.isEmpty()) {
            errorTextView.setText("Поле 'Адрес (Куда)' не должно быть пустым");
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }



        UserData userData = UserData.getInstance();
        userData.setFromName(firstNameText);
userData.setFromAdress(lastNameText);
userData.setToName(toNameInputValue);
userData.setToAdress(toAdressInputValue);
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);

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