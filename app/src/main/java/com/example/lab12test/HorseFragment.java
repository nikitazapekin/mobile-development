package com.example.lab12test;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewbindingactivityfragment.R;
import com.example.viewbindingactivityfragment.databinding.FragmentHorseBinding;

public class HorseFragment extends Fragment {

    private FragmentHorseBinding binding;
    private MainViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHorseBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnSubmit.setOnClickListener(v -> addHorse());

        return binding.getRoot();
    }
    private void addHorse() {
        String name = binding.etName.getText().toString().trim();
        String ageStr = binding.etAge.getText().toString().trim();
        String ownerIdStr = binding.etOwnerId.getText().toString().trim();

        // Проверка на пустые поля
        if (name.isEmpty() || ageStr.isEmpty() || ownerIdStr.isEmpty()) {
            showErrorDialog("Пожалуйста, заполните все поля.");
            return;
        }

        // Преобразование данных
        int age = Integer.parseInt(ageStr);
        long ownerId = Long.parseLong(ownerIdStr);

        Horse horse = new Horse();
        horse.setName(name);
        horse.setAge(age);
        horse.setOwner_id(ownerId);


        viewModel.insertHorse(horse);
        Toast.makeText(getContext(), "Лошадь добавлена!", Toast.LENGTH_SHORT).show();


        getParentFragmentManager().popBackStack();
    }

    // Диалог с ошибкой
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

