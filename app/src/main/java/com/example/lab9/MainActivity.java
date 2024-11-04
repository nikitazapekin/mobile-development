package com.example.lab9;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new MyServer(this));


        if (getLifecycle() .getCurrentState() == Lifecycle.State.RESUMED) {


        }
        if (getLifecycle() .getCurrentState() .isAtLeast (Lifecycle.State.STARTED)) {


        }

        textView = findViewById(R.id.test);


        DataController.getInstance().setData("123");
   LiveData<String> liveData = DataController.getInstance().getData() ;

        liveData.observe (this, new Observer<String>() {

            public void onChanged(@Nullable String value) {
                textView.setText(value);
            }
        });

        /* DataController dataController = DataController.getInstance();
        mediatorLiveData.observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        log("onChanged " + s);
                    }
                }
*/

        DataController dataController = DataController.getInstance();


         dataController.getMediatorLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(TAG, "onChanged: " + s);
            }
        });

        dataController.setData("Hello, World!");






        MyViewModel  viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        String nameText = viewModel.getNameText();
   
        textView.setText(nameText);


        EditText editText  = findViewById(R.id.editTextText);
        Button button  = findViewById(R.id.button);
        TextView textView1 = findViewById(R.id.textView);

        button.setOnClickListener(view-> {
            textView1.setText(editText.getText());

            viewModel.saveText(editText.getText().toString());
        } );


        String text = viewModel.loadText();
         if( text!=null) {
textView1.setText(text);
         }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}
