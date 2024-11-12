package com.example.lab9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DetailFragment extends Fragment {

    private CarViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        viewModel = new ViewModelProvider(requireActivity()).get(CarViewModel.class);

        TextView titleView = view.findViewById(R.id.title);
        TextView descView = view.findViewById(R.id.describtion);
        TextView descFullView = view.findViewById(R.id.fullDescribtion);
        TextView price = view.findViewById(R.id.price);
      ImageView imageView = view.findViewById(R.id.logo);
        viewModel.getSelectedCar().observe(getViewLifecycleOwner(), car -> {
            if (car != null) {
                titleView.setText(car.getName());
                price.setText(car.getPrice()+ "$");
                descView.setText(car.getDescribtion());
                descFullView.setText(car.getFullDescribtion());
                imageView.setImageResource(car.getLogo());

            }
        });

        return view;
    }
}
