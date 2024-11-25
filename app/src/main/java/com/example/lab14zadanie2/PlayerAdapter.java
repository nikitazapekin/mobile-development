package com.example.lab14zadanie2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private final List<Player> players;

    public PlayerAdapter(List<Player> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = players.get(position);
        holder.numberTextView.setText(String.valueOf(player.getNumber()));
        holder.surnameTextView.setText(player.getSurname());
        if (player.getFilePath() != null) {
            holder.imageView.setImageDrawable(holder.imageView.getContext()
                    .getDrawable(R.drawable.ic_launcher_background));
        }
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextView numberTextView;
        TextView surnameTextView;
        ImageView imageView;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            numberTextView = itemView.findViewById(R.id.player_number);
            surnameTextView = itemView.findViewById(R.id.player_surname);
            imageView = itemView.findViewById(R.id.player_image);
        }
    }
}
