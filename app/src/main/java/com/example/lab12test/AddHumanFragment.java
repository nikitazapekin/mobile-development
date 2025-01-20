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
import com.example.viewbindingactivityfragment.databinding.FragmentAddHumanBinding;


public class AddHumanFragment extends Fragment {

    private FragmentAddHumanBinding binding;
    private MainViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddHumanBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnAddCustomer.setOnClickListener(v -> addHuman());
        return binding.getRoot();
    }

    private void addHuman() {
        String name = binding.etName.getText().toString().trim();
        String lastName = binding.etLastName.getText().toString().trim();
        String phone = binding.etPhone.getText().toString().trim();

        if (name.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
            showErrorDialog("Пожалуйста, заполните все поля.");
            return;
        }

        Human human = new Human();
        human.name = name;
      human.lastName = lastName;
      human.phone = phone;

        viewModel.insertHuman(human);
        getParentFragmentManager().popBackStack();
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

