package com.example.lab11variant22;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherItem> weatherList;

    public void setWeatherList(List<WeatherItem> weatherList) {
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherItem item = weatherList.get(position);
        holder.dateTextView.setText(item.getDate());
        holder.tempTextView.setText(String.format("%s°C", item.getMain().getTemp()));
        holder.descTextView.setText(item.getWeather()[0].getDescription());
    }

    @Override
    public int getItemCount() {
        return weatherList == null ? 0 : weatherList.size();
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView, tempTextView, descTextView;

        WeatherViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            tempTextView = itemView.findViewById(R.id.tempTextView);
            descTextView = itemView.findViewById(R.id.descTextView);
        }
    }
}
