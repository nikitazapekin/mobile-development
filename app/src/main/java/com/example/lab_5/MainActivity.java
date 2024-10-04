package com.example.lab_5;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
View progressBar =  findViewById(R.id.view);
        ProgressBar progressBarElement = findViewById(R.id.progressBar);

        new Handler().postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            progressBarElement.setVisibility(View.GONE);
        }, 5000);


         */
    }











    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }
    }



}



/*


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] itemNames = {"Пицца Маргарита", "Пицца Пепперони", "Пицца 4 сыра"};
    private String[] itemPrices = {"300₽", "350₽", "400₽"};
    private int[] itemImages = {R.drawable.pizza_margherita, R.drawable.pizza_pepperoni, R.drawable.pizza_four_cheese};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, itemNames, itemPrices, itemImages);
        listView.setAdapter(adapter);
    }

    class CustomAdapter extends BaseAdapter {

        private Context context;
        private String[] itemNames;
        private String[] itemPrices;
        private int[] itemImages;
        private LayoutInflater inflater;

        public CustomAdapter(Context context, String[] itemNames, String[] itemPrices, int[] itemImages) {
            this.context = context;
            this.itemNames = itemNames;
            this.itemPrices = itemPrices;
            this.itemImages = itemImages;
            this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return itemNames.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item, parent, false);
            }

            ImageView imageView = convertView.findViewById(R.id.itemImage);
            TextView nameView = convertView.findViewById(R.id.itemName);
            TextView priceView = convertView.findViewById(R.id.itemPrice);

            imageView.setImageResource(itemImages[position]);
            nameView.setText(itemNames[position]);
            priceView.setText(itemPrices[position]);

            return convertView;
        }
    }
}

 */


/*
package com.example.lab_5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

*/