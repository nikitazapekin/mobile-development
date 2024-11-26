package com.example.lab8ksen;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OlympicSportAdapter extends ArrayAdapter<OlympicSport> {
    private Context context;
    private List<OlympicSport> sports;

    public OlympicSportAdapter(@NonNull Context context, int resource, @NonNull List<OlympicSport> objects) {
        super(context, resource, objects);
        this.context = context;
        this.sports = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        OlympicSport currentSport = sports.get(position);

        TextView nameTextView = convertView.findViewById(R.id.name_text_view);
        TextView detailsTextView = convertView.findViewById(R.id.details_text_view);
        ImageView logoImageView = convertView.findViewById(R.id.imageViewList);

        nameTextView.setText(currentSport.getName());
        detailsTextView.setText(
                (currentSport.isSummer() ? "Summer" : "Winter") +
                        ", " + (currentSport.isTeam() ? "Team" : "Individual") +
                        ", Recognized: " + currentSport.getRecognitionYear()
        );
        logoImageView.setImageResource(currentSport.getLogo());

        return convertView;
    }
}
