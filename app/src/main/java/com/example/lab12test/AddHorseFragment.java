package com.example.lab12test;


import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewbindingactivityfragment.R;
import com.example.viewbindingactivityfragment.databinding.FragmentAddHorseBinding;



public class AddHorseFragment extends Fragment {

    private FragmentAddHorseBinding binding;
    private static final String ARG_HUMAN_ID = "human_id";
    private long humanId;
    private MainViewModel viewModel;

    public static AddHorseFragment newInstance(long humanId) {
        AddHorseFragment fragment = new AddHorseFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_HUMAN_ID, humanId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            humanId = getArguments().getLong(ARG_HUMAN_ID);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddHorseBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnAddHorse.setOnClickListener(v -> addPurchase());
        return binding.getRoot();
    }

    private void addPurchase() {
        String name = binding.etProduct.getText().toString().trim();
        String age = binding.etAge.getText().toString().trim();

      Horse horse = new Horse();
        horse.name = name;
        horse.age = Integer.parseInt(age);
    //    horse.price = Double.parseDouble(priceStr);
        horse.humanId = humanId;

        viewModel.insertHorse(horse);
        getParentFragmentManager().popBackStack();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_alert_dialog, null);
        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();

        TextView tvMessage = dialogView.findViewById(R.id.tvMessage);
        TextView btnOk = dialogView.findViewById(R.id.btnOk);

        tvMessage.setText(message);

        btnOk.setOnClickListener(v -> alertDialog.dismiss());

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        alertDialog.show();
    }
}