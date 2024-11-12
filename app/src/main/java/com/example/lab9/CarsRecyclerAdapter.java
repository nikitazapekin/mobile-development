package com.example.lab9;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarsRecyclerAdapter  extends RecyclerView.Adapter<CarsRecyclerAdapter.CarsViewHolder> {



    private List<Car> carsList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Car car);
    }

    public CarsRecyclerAdapter(List<Car> carsList, OnItemClickListener listener) {
        this.carsList = carsList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_recycler_item, parent, false);
        return new CarsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        Car car = carsList.get(position);
        holder.bind(car, listener);
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public static class CarsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView priceTextView;
        private TextView describtionTextView;

        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);


            titleTextView = itemView.findViewById(R.id.titleView);
            describtionTextView = itemView.findViewById(R.id.describtionView);
            priceTextView = itemView.findViewById(R.id.priceView);
         imageView = itemView.findViewById(R.id.imageView);

        }

        public void bind(Car car, OnItemClickListener listener) {

titleTextView.setText(car.getName());
describtionTextView.setText(car.getDescribtion());
priceTextView.setText(car.getPrice()+"$");
imageView.setImageResource(car.getLogo());


                itemView.setOnClickListener(v -> listener.onItemClick(car));


        }
    }
}

