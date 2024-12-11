package com.example.lab12test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewbindingactivityfragment.R;

import java.util.List;
public class HorseAdapter extends RecyclerView.Adapter<HorseAdapter.HorseViewHolder> {

    private List<Horse> horseList;


    public HorseAdapter(List<Horse> horseList) {
        this.horseList = horseList;
    }

    @NonNull
    @Override
    public HorseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horse, parent, false);
        return new HorseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorseViewHolder holder, int position) {
        Horse horse = horseList.get(position);
        holder.nameTextView.setText(horse.getName());
        holder.ageTextView.setText(String.valueOf(horse.getAge()));
    }

    @Override
    public int getItemCount() {
        return horseList.size();
    }


    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
        notifyDataSetChanged();
    }

    public static class HorseViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView ageTextView;

        public HorseViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.horse_name);
            ageTextView = itemView.findViewById(R.id.horse_age);
        }
    }
}
