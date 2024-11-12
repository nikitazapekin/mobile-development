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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smartphone_recycler_item, parent, false);
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
        private TextView brandTextView;
        private TextView priceTextView;
        private TextView memoryTextView;

        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.smartphone_image);
            brandTextView = itemView.findViewById(R.id.smartphone_brand);
            priceTextView = itemView.findViewById(R.id.smartphone_price);
            memoryTextView = itemView.findViewById(R.id.smartphone_memory);
        }

        public void bind(Car car, OnItemClickListener listener) {
            brandTextView.setText(car.getName());



                itemView.setOnClickListener(v -> listener.onItemClick(car));


        }
    }
}

