package com.example.lab11new;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SunriseSunsetAdapter extends RecyclerView.Adapter<SunriseSunsetAdapter.ViewHolder> {

    private final List<Item> items;

    public static class Item {
        public double latitude;
        public String sunrise;
        public String sunset;

        public Item(double latitude, String sunrise, String sunset) {
            this.latitude = latitude;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }
    }

    public SunriseSunsetAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sunrise_sunset, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.latitudeTextView.setText("Широта: " + item.latitude);
        holder.sunriseTextView.setText("Восход: " + item.sunrise);
        holder.sunsetTextView.setText("Закат: " + item.sunset);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView latitudeTextView, sunriseTextView, sunsetTextView;

        ViewHolder(View itemView) {
            super(itemView);
            latitudeTextView = itemView.findViewById(R.id.latitudeTextView);
            sunriseTextView = itemView.findViewById(R.id.sunriseTextView);
            sunsetTextView = itemView.findViewById(R.id.sunsetTextView);
        }
    }
}
