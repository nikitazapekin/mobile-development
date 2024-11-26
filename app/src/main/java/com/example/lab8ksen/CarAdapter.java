package com.example.lab8ksen;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CarAdapter extends ArrayAdapter<Car> {
    private Context context;
    private List<Car> cars;

    public CarAdapter(@NonNull Context context, int resource, @NonNull List<Car> objects) {
        super(context, resource, objects);
        this.context = context;
        this.cars = objects;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        Car currentCar = cars.get(position);

        TextView nameTextView = convertView.findViewById(R.id.name_text_view);
        TextView priceTextView = convertView.findViewById(R.id.price_text_view);
        TextView describtionTextView = convertView.findViewById(R.id.describtion_text_view);
        ImageView imageView = convertView.findViewById(R.id.imageViewList);

        nameTextView.setText(currentCar.getName());
        priceTextView.setText(String.valueOf(currentCar.getPrice()));
        describtionTextView.setText(currentCar.getDescribtion());
        int imageResId = currentCar.getLogo();
        imageView.setImageResource(imageResId);

        return convertView;
    }


}