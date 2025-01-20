
package com.example.lab12test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewbindingactivityfragment.databinding.FragmentHorseDetailsBinding;

public class HorseDetailsFragment extends Fragment {

    private FragmentHorseDetailsBinding binding;
    private static final String ARG_PURCHASE_ID = "purchase_id";
    private long purchaseId;

    private HorseViewModel viewModel;

    public static HorseDetailsFragment newInstance(long purchaseId) {
        HorseDetailsFragment fragment = new HorseDetailsFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PURCHASE_ID, purchaseId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            purchaseId = getArguments().getLong(ARG_PURCHASE_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHorseDetailsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(HorseViewModel.class);
        observeHorseDetails();
        return binding.getRoot();
    }

    private void observeHorseDetails() {
        viewModel.getHorseById(purchaseId).observe(getViewLifecycleOwner(), horse -> {
            if (horse != null) {
                displayHorseDetails(horse);
            }
        });
    }

    private void displayHorseDetails(Horse horse) {
        binding.tvProduct.setText(horse.name);  // Тут должно быть отображение нужных данных
        binding.tvCount.setText(String.valueOf(horse.age));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

/*
package com.example.lab12test;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewbindingactivityfragment.databinding.FragmentHorseDetailsBinding;



public class HorseDetailsFragment extends Fragment {

    private FragmentHorseDetailsBinding binding;
  //  private FragmentPurchaseDetailsBinding binding;
    private static final String ARG_PURCHASE_ID = "purchase_id";
    private long purchaseId;

    private PurchaseViewModel viewModel;

    public static HorseDetailsFragment newInstance(long purchaseId) {
        HorseDetailsFragment fragment = new HorseDetailsFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PURCHASE_ID, purchaseId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            purchaseId = getArguments().getLong(ARG_PURCHASE_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHorseDetailsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(HorseViewModel.class);
        observeHorseDetails();
        return binding.getRoot();
    }

    private void observeHorseDetails() {
        viewModel.getHorseById(horseId).observe(getViewLifecycleOwner(), horse -> {

            //    viewModel.getHorseById(horseId).observe(getViewLifecycleOwner(), horse -> {
            if (horse != null) {
                displayHorseDetails(horse);
            }
        });
    }

    private void displayHorseDetails(Horse horse) {
        binding.tvProduct.setText(horse.name);
        binding.tvCount.setText(String.valueOf(horse.age));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
*/