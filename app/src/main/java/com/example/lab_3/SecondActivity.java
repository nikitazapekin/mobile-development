package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    private ActivityResultLauncher<Intent> thirdActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    String fromName = result.getData().getStringExtra("fromName");
                    String fromAddress = result.getData().getStringExtra("fromAddress");
                    String toName = result.getData().getStringExtra("toName");
                    String toAddress = result.getData().getStringExtra("toAddress");

                    TextView boxWithText = findViewById(R.id.box_with_text);
                    String tripInfo = "Поездка из:\nНазвание: " + fromName + "\nАдрес: " + fromAddress +
                            "\nдо:\nНазвание: " + toName + "\nАдрес: " + toAddress + "\nПодтвердить заказ?";
                    boxWithText.setText(tripInfo);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String firstName = extras.getString("firstName");
            String lastName = extras.getString("lastName");
            String phone = extras.getString("phone");


            TextView textView = findViewById(R.id.textView);
            textView.setText("Имя: " + firstName + "\nФамилия: " + lastName + "\nТелефон: " + phone);
        }


        TextView boxWithText = findViewById(R.id.box_with_text);
        String fromName = extras != null ? extras.getString("fromName") : null;
        String fromAddress = extras != null ? extras.getString("fromAddress") : null;
        String toName = extras != null ? extras.getString("toName") : null;
        String toAddress = extras != null ? extras.getString("toAddress") : null;

        if (fromName == null || fromAddress == null || toName == null || toAddress == null) {
            boxWithText.setText("Поездка не выбрана");
        } else {
            String tripInfo = "Поездка из:\nНазвание: " + fromName + "\nАдрес: " + fromAddress +
                    "\nдо:\nНазвание: " + toName + "\nАдрес: " + toAddress + "\nПодтвердить заказ?";
            boxWithText.setText(tripInfo);
        }
    }


    public void handleRedirect(View view) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        thirdActivityLauncher.launch(intent);
    }


    public void handleSubmit(View view) {

        TextView boxWithText = findViewById(R.id.box_with_text);
        String text = boxWithText.getText().toString();

        if (text.contains("не выбрана")) {
            Toast.makeText(SecondActivity.this, "Пожалуйста, выберите путь!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SecondActivity.this, "Такси в пути!", Toast.LENGTH_SHORT).show();
        }
    }
}

