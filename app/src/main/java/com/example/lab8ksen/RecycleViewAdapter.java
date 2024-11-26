

package com.example.lab8ksen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab8ksen.OlympicSport;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter< RecycleViewAdapter.ViewHolder> {


    interface  OnSportsClickListener {
        void onSportClick(OlympicSport sport, int position);

    }
    private OnSportsClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<OlympicSport> sports;

  RecycleViewAdapter(Context context, List<OlympicSport> sports, OnSportsClickListener onClickListener) {
        this.sports = sports;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
      OlympicSport sport = sports.get(position);
        OlympicSport currentSport = sports.get(position);
        holder.nameView.setText(sport.getName());
      //
        //  holder.categoryView.setText(sport.getRecognitionYear());

        holder.categoryView.setText(
                (currentSport.isSummer() ? "Summer" : "Winter") +
                   //     ", " + (currentSport.isTeam() ? "Team" : "Individual") +
                        ", Recognized: " + currentSport.getRecognitionYear()
        );
        holder.imageView.setImageResource(sport.getLogo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  onClickListener.onSportClick(sport, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
      //  final TextView nameView, priceView, descriptionView;
      final TextView nameView,  categoryView;
        final ImageView imageView;
        ViewHolder(View view) {
            super(view);

            nameView = view.findViewById(R.id.name_text_view1);

           categoryView = view.findViewById(R.id.category_text_view1);
            imageView = view.findViewById(R.id.imageViewRecycler);
        }
    }



}
