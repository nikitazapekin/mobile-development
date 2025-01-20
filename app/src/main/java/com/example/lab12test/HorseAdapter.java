package com.example.lab12test;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewbindingactivityfragment.R;


public class HorseAdapter extends ListAdapter<Horse, HorseAdapter.HorseViewHolder> {
    private final OnHorseClickListener onHorseClickListener;

    public interface OnHorseClickListener {
        void onHorseClick(Horse horse);
    }

    public HorseAdapter(OnHorseClickListener listener) {
        super(DIFF_CALLBACK);
        this.onHorseClickListener = listener;
    }

    private static final DiffUtil.ItemCallback<Horse> DIFF_CALLBACK = new DiffUtil.ItemCallback<Horse>() {
        @Override
        public boolean areItemsTheSame(@NonNull Horse oldItem, @NonNull Horse newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Horse oldItem, @NonNull Horse newItem) {
         return oldItem.name.equals(newItem.name) &&
                    oldItem.age.equals(newItem.age) &&

                    oldItem.humanId == newItem.humanId;



        }
    };

    @NonNull
    @Override
    public HorseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horse, parent, false);
        return new HorseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorseViewHolder holder, int position) {
        Horse horse = getItem(position);
        holder.bind(horse);
    }

    class  HorseViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvProduct;
        private final TextView tvDetails;

        public HorseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProduct = itemView.findViewById(R.id.tv_product);
            tvDetails = itemView.findViewById(R.id.tv_details);

            itemView.setOnClickListener(v -> {

                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onHorseClickListener.onHorseClick(getItem(position));
                }
            });
        }

        public void bind(Horse horse) {
            tvProduct.setText("Название : "+horse.name);
            tvDetails.setText("Возраст: " + horse.age );
        }
    }
}