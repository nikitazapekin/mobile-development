
package com.example.lab11;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MarvelEventAdapter extends RecyclerView.Adapter<MarvelEventAdapter.EventViewHolder> {

    private List<MarvelResponse.Event> events;

    public MarvelEventAdapter(List<MarvelResponse.Event> events) {
        this.events = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        MarvelResponse.Event event = events.get(position);
        holder.titleTextView.setText(event.getTitle());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public EventViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}


/*
package com.example.lab11;

public class MarvelEventAdapter {
}
*/