
package com.example.lab11fix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MarvelItemAdapter extends RecyclerView.Adapter<MarvelItemAdapter.MarvelItemViewHolder> {

    private List<MarvelItem> marvelItems = new ArrayList<>();

    @NonNull
    @Override
    public MarvelItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marvel, parent, false);
        return new MarvelItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarvelItemViewHolder holder, int position) {
        MarvelItem item = marvelItems.get(position);
        holder.nameTextView.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return marvelItems.size();
    }

    public void setMarvelItems(List<MarvelItem> items) {
        this.marvelItems = items;
        notifyDataSetChanged();  // Обновляем RecyclerView
    }

    public static class MarvelItemViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;

        public MarvelItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView); // Инициализируйте TextView для имени
        }
    }
}
