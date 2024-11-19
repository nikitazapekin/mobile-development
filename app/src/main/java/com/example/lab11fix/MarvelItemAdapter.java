package com.example.lab11fix;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MarvelItemAdapter extends RecyclerView.Adapter<MarvelItemAdapter.ViewHolder> {

    private List<MarvelItem> marvelItems = new ArrayList<>();

    public void setMarvelItems(List<MarvelItem> items) {
        this.marvelItems = items;
        notifyDataSetChanged();
        Log.d("AdapterUpdate", "Setting items: " + items.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marvel, parent, false);
        return new ViewHolder(view);
    }
    /*
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MarvelItem item = marvelItems.get(position);
        holder.nameTextView.setText(item.getName());
        holder.resourceUriTextView.setText(item.getResourceURI());
    }

     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MarvelItem item = marvelItems.get(position);
        Log.d("Adapter", "Binding item at position " + position + ": " + item.getName());
        holder.nameTextView.setText(item.getName());
        holder.resourceUriTextView.setText(item.getResourceURI());
    }

    @Override
    public int getItemCount() {
        return marvelItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, resourceUriTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            resourceUriTextView = itemView.findViewById(R.id.resourceUriTextView);
        }
    }
}
