package com.example.lab12test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewbindingactivityfragment.R;

public class HumanAdapter extends ListAdapter<Human, HumanAdapter.HumanViewHolder> {
    private final OnHumanClickListener onHumanClickListener;
    private final OnDeleteClickListener onDeleteClickListener;

    public interface OnHumanClickListener {
        void onHumanClick(Human human);
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(Human human);
    }

    public HumanAdapter(OnHumanClickListener clickListener, OnDeleteClickListener deleteListener) {
        super(DIFF_CALLBACK);
        this.onHumanClickListener = clickListener;
        this.onDeleteClickListener = deleteListener;
    }

    private static final DiffUtil.ItemCallback<Human> DIFF_CALLBACK = new DiffUtil.ItemCallback<Human>() {
        @Override
        public boolean areItemsTheSame(@NonNull Human oldItem, @NonNull Human newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Human oldItem, @NonNull Human newItem) {
            return oldItem.name.equals(newItem.name) &&
                    oldItem.age == newItem.age &&
                    oldItem.phone.equals(newItem.phone);
        }
    };

    @NonNull
    @Override
    public HumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_human, parent, false);
        return new HumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HumanViewHolder holder, int position) {
        Human human = getItem(position);
        holder.bind(human);
    }

    class HumanViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvPhone;
        private final TextView tvId;
        private final TextView tvAge;
        private final Button btnDelete;

        public HumanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text_name);
            tvPhone = itemView.findViewById(R.id.text_phone);
            tvId = itemView.findViewById(R.id.text_id);
            tvAge = itemView.findViewById(R.id.text_age);
            btnDelete = itemView.findViewById(R.id.btn_delete);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onHumanClickListener.onHumanClick(getItem(position));
                }
            });
        }

        public void bind(Human human) {
            tvName.setText("Имя: " + human.name);
            tvAge.setText("Возраст: " + human.age);
            tvPhone.setText("Телефон: " + human.phone);
            tvId.setText("ID: " + human.id);

            btnDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onDeleteClickListener.onDeleteClick(getItem(position));
                }
            });
        }
    }
}
