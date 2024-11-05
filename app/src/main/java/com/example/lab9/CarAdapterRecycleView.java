package com.example.lab9;




import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarAdapterRecycleView extends RecyclerView.Adapter<CarAdapterRecycleView.ViewHolder> {


    interface  OnCarsClickListener {
        void onCarClick(Car car, int position);

    }
    private OnCarsClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<Car> cars;

    CarAdapterRecycleView(Context context, List<Car> cars, OnCarsClickListener onClickListener) {
        this.cars = cars;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Car car = cars.get(position);
        holder.nameView.setText(car.getName());
        holder.priceView.setText(String.valueOf(car.getPrice()));
        holder.descriptionView.setText(car.getDescribtion());
        holder.imageView.setImageResource(car.getLogo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onCarClick(car, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, priceView, descriptionView;
        final ImageView imageView;
        ViewHolder(View view) {
            super(view);

            nameView = view.findViewById(R.id.name_text_view1);
            priceView = view.findViewById(R.id.price_text_view1);
            descriptionView = view.findViewById(R.id.describtion_text_view1);
            imageView = view.findViewById(R.id.imageViewRecycler);
        }
    }



}
