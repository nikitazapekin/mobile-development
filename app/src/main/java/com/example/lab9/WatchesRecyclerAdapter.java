package com.example.lab9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WatchesRecyclerAdapter extends RecyclerView.Adapter<WatchesRecyclerAdapter.WatchesViewHolder> {

    private List<Watch> watchesList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Watch watch);
    }

    public WatchesRecyclerAdapter(List<Watch> watchesList, OnItemClickListener listener) {
        this.watchesList = watchesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public WatchesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.watch_recycler_item, parent, false);
        return new WatchesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchesViewHolder holder, int position) {
        Watch watch = watchesList.get(position);
        holder.bind(watch, listener);
    }

    @Override
    public int getItemCount() {
        return watchesList.size();
    }

    public static class WatchesViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView brandTextView;
        private TextView typeTextView;
        private TextView priceTextView;

        public WatchesViewHolder(@NonNull View itemView) {
            super(itemView);

            brandTextView = itemView.findViewById(R.id.titleView);
       //     typeTextView = itemView.findViewById(R.id.typeView);
            priceTextView = itemView.findViewById(R.id.priceView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(Watch watch, OnItemClickListener listener) {
          brandTextView.setText(watch.getBrand());

            priceTextView.setText("$" + watch.getPrice());
            imageView.setImageResource(watch.getPhoto());

            itemView.setOnClickListener(v -> listener.onItemClick(watch));
        }
    }
}
