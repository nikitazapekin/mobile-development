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

public class CustomerAdapter extends ListAdapter<Customer, CustomerAdapter.CustomerViewHolder> {
    private final OnCustomerClickListener onCustomerClickListener;
    private final OnDeleteClickListener onDeleteClickListener;

    public interface OnCustomerClickListener {
        void onCustomerClick(Customer customer);
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(Customer customer);
    }

    public CustomerAdapter(OnCustomerClickListener clickListener, OnDeleteClickListener deleteListener) {
        super(DIFF_CALLBACK);
        this.onCustomerClickListener = clickListener;
        this.onDeleteClickListener = deleteListener;
    }

    private static final DiffUtil.ItemCallback<Customer> DIFF_CALLBACK = new DiffUtil.ItemCallback<Customer>() {
        @Override
        public boolean areItemsTheSame(@NonNull Customer oldItem, @NonNull Customer newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Customer oldItem, @NonNull Customer newItem) {
            return oldItem.name.equals(newItem.name) &&
                    oldItem.lastName.equals(newItem.lastName) &&
                    oldItem.phone.equals(newItem.phone);
        }
    };

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = getItem(position);
        holder.bind(customer);
    }

    class CustomerViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvPhone;
        private final TextView tvId;


        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text_name);
            tvPhone = itemView.findViewById(R.id.text_phone);
            tvId = itemView.findViewById(R.id.text_id);


            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onCustomerClickListener.onCustomerClick(getItem(position));
                }
            });
        }

        public void bind(Customer customer) {
            tvName.setText("Пользователь: " + customer.name + " " + customer.lastName);
            tvPhone.setText("Номер телефона: " + customer.phone);
            tvId.setText("Номер пользователя: " + customer.id);



        }
    }
}


/*
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


public class CustomerAdapter extends ListAdapter<Customer, CustomerAdapter.CustomerViewHolder> {
    private final OnCustomerClickListener onCustomerClickListener;
    private final OnDeleteClickListener onDeleteClickListener;


    public interface OnCustomerClickListener {
        void onCustomerClick(Customer customer);
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(Customer customer);
    }

    public CustomerAdapter(OnCustomerClickListener listener) {
        super(DIFF_CALLBACK);
        this.onCustomerClickListener = listener;
        this.onDeleteClickListener = deleteListener;
    }

    private static final DiffUtil.ItemCallback<Customer> DIFF_CALLBACK = new DiffUtil.ItemCallback<Customer>() {
        @Override
        public boolean areItemsTheSame(@NonNull Customer oldItem, @NonNull Customer newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Customer oldItem, @NonNull Customer newItem) {
            return oldItem.name.equals(newItem.name) &&
                    oldItem.lastName.equals(newItem.lastName) &&

                    oldItem.phone.equals(newItem.phone);
        }
    };

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = getItem(position);
        holder.bind(customer);
    }

    class CustomerViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvPhone;
        private final TextView tvId;
        private  final ImageButton btnDelete;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text_name);
            tvPhone = itemView.findViewById(R.id.text_phone);
            tvId = itemView.findViewById(R.id.text_id);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onCustomerClickListener.onCustomerClick(getItem(position));
                }
            });
        }

        public void bind(Customer customer) {
            tvName.setText("Пользователь: "+customer.name + " " + customer.lastName);
            tvPhone.setText("Номер телефона: "+customer.phone);
            tvId.setText("Номер пользователя: "+customer.id);
        }
    }
}
*/