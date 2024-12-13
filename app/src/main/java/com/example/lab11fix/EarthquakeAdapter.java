package com.example.lab11fix;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {

    private final List<EarthquakeResponse.Feature> earthquakes;

    public EarthquakeAdapter(List<EarthquakeResponse.Feature> earthquakes) {
        this.earthquakes = earthquakes;
    }

    @NonNull
    @Override
    public EarthquakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_earthquake, parent, false);
        return new EarthquakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EarthquakeViewHolder holder, int position) {
        EarthquakeResponse.Feature earthquake = earthquakes.get(position);
        holder.placeTextView.setText(earthquake.getProperties().getPlace());
        holder.magnitudeTextView.setText(String.valueOf(earthquake.getProperties().getMag()));
        holder.timeTextView.setText(formatDate(earthquake.getProperties().getTime()));
    }

    @Override
    public int getItemCount() {
        return earthquakes.size();
    }

    public static class EarthquakeViewHolder extends RecyclerView.ViewHolder {
        TextView placeTextView, magnitudeTextView, timeTextView;

        public EarthquakeViewHolder(@NonNull View itemView) {
            super(itemView);
            placeTextView = itemView.findViewById(R.id.placeTextView);
            magnitudeTextView = itemView.findViewById(R.id.magnitudeTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }

    private String formatDate(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
                .format(new Date(timestamp));
    }
}
