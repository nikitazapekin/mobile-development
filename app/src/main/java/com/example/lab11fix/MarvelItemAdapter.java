package com.example.lab11fix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MarvelItemAdapter extends RecyclerView.Adapter<MarvelItemAdapter.ViewHolder> {

    private final List<MarvelItem> marvelItems = new ArrayList<>();

    public void setMarvelItems(List<MarvelItem> items) {
        marvelItems.clear();
        marvelItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marvel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MarvelItem item = marvelItems.get(position);
        holder.nameTextView.setText(item.getName());

        if (item.getThumbnailUrl() != null) {
           Glide.with(holder.thumbnailImageView.getContext())
                    .load(item.getThumbnailUrl())
                    .into(holder.thumbnailImageView);
        }
    }

    @Override
    public int getItemCount() {
        return marvelItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView thumbnailImageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            thumbnailImageView = itemView.findViewById(R.id.thumbnailImageView);
        }
    }
}

/*

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
        holder.resourseTextView.setText(item.getResourceURI());

    }

    @Override
    public int getItemCount() {
        return marvelItems.size();
    }

    public void setMarvelItems(List<MarvelItem> items) {
        this.marvelItems = items;
        notifyDataSetChanged();
    }

    public static class MarvelItemViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView resourseTextView;

        public MarvelItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
          resourseTextView = itemView.findViewById(R.id.resourceUriTextView);

        }
    }
}
*/