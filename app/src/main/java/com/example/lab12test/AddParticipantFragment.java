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
import com.example.viewbindingactivityfragment.databinding.FragmentAddParticipantBinding;

public class AddParticipantFragment extends Fragment {

    private FragmentAddParticipantBinding binding;
    private MainViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddParticipantBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnSubmit.setOnClickListener(v -> addCustomer());
        return binding.getRoot();
    }

    private void addCustomer() {
        String name = binding.etName.getText().toString().trim();
        String  age= binding.etAge.getText().toString().trim();
        String phone = binding.etPhone.getText().toString().trim();

        if (name.isEmpty()  || age.isEmpty() ||  phone.isEmpty()) {
            showErrorDialog("Пожалуйста, заполните все поля.");
            return;
        }


        Human human = new Human();
human.name = name;
human.age = Integer.parseInt(age);
human.phone =phone;
      //  viewModel.insertCustomer(customer);
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


/*
package com.example.lab12test;

public class AddParticipant {
}
*/