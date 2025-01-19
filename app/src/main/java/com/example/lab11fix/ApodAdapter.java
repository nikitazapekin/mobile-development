package com.example.lab11fix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ApodAdapter extends RecyclerView.Adapter<ApodAdapter.ViewHolder> {

    private final List<NasaImage> apodList;
    private final Context context;

    public ApodAdapter(Context context, List<NasaImage> apodList) {
        this.context = context;
        this.apodList = apodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_apod, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NasaImage apod = apodList.get(position);

        holder.titleTextView.setText(apod.getTitle());
        holder.descriptionTextView.setText(apod.getExplanation());
        Glide.with(context).load(apod.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return apodList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView, descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.apodImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
