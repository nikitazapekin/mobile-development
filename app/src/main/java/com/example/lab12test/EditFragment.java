package com.example.lab12test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.viewbindingactivityfragment.databinding.FragmentCustomersBinding;
import com.example.viewbindingactivityfragment.databinding.FragmentEditBinding;

public class EditFragment extends Fragment {

    private FragmentEditBinding binding;

    private MainViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditBinding.inflate(inflater, container, false);

        setupRecyclerView();
        setupViewModel();
        setupFab();

        return binding.getRoot();
    }



/*
    private void editCustomer() {

        String id = binding.editId.getText().toString().trim();
        String name = binding.editName.getText().toString().trim();
        String lastName = binding.editLastName.getText().toString().trim();
        String phone = binding.editPhone.getText().toString().trim();



        Customer customer = new Customer();
        customer.name = name;
        customer.lastName = lastName;
        customer.phone = phone;

        viewModel.updateCustomer(customer);
        getParentFragmentManager().popBackStack();
    }

    private void deleteCustomer() {
        String id = binding.editId.getText().toString().trim();
        String name = binding.editName.getText().toString().trim();
        String lastName = binding.editLastName.getText().toString().trim();
        String phone = binding.editPhone.getText().toString().trim();
        Customer customer = new Customer();
        customer.name = name;
        customer.lastName = lastName;
        customer.phone = phone;
        viewModel.deleteCustomer(customer);
        getParentFragmentManager().popBackStack();

    }

*/


    private void editCustomer() {
        String idString = binding.editId.getText().toString().trim();
        String name = binding.editName.getText().toString().trim();
        String lastName = binding.editLastName.getText().toString().trim();
        String phone = binding.editPhone.getText().toString().trim();

        if (!idString.isEmpty()) {
            long id = Long.parseLong(idString);

            Customer customer = new Customer();
            customer.id = id; // Важное исправление — установка ID
            customer.name = name;
            customer.lastName = lastName;
            customer.phone = phone;

            viewModel.updateCustomer(customer);
            getParentFragmentManager().popBackStack();
        } else {
            // Обработка ошибки, если ID не указан
            binding.editId.setError("ID is required for editing");
        }
    }
/*
    private void deleteCustomer() {
        String idString = binding.editId.getText().toString().trim();

        if (!idString.isEmpty()) {
            long id = Long.parseLong(idString);

            viewModel.getCustomerById(id).observe(getViewLifecycleOwner(), customer -> {
                if (customer != null) {
                    viewModel.deleteCustomer(customer);
                    getParentFragmentManager().popBackStack();
                } else {
                    // Обработка ошибки, если клиент с указанным ID не найден
                    binding.editId.setError("Customer not found");
                }
            });
        } else {
            // Обработка ошибки, если ID не указан
            binding.editId.setError("ID is required for deletion");
        }
    }

*/

    private void setupRecyclerView() {

    }

    private void setupViewModel() {

       viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    //   viewModel.getCustomers().observe(getViewLifecycleOwner(), adapter::submitList);
    }

    private void setupFab() {
        binding.editEditCustomer.setOnClickListener(v -> editCustomer());
      //  binding.editDeleteCustomer.setOnClickListener(v ->deleteCustomer());

    }

}


/*


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
import com.example.viewbindingactivityfragment.databinding.FragmentAddCustomerBinding;

public class AddCustomerFragment extends Fragment {

    private FragmentAddCustomerBinding binding;
    private MainViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddCustomerBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnAddCustomer.setOnClickListener(v -> addCustomer());
        return binding.getRoot();
    }

    private void addCustomer() {
        String name = binding.etName.getText().toString().trim();
        String lastName = binding.etLastName.getText().toString().trim();
        String phone = binding.etPhone.getText().toString().trim();

        if (name.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
            showErrorDialog("Пожалуйста, заполните все поля.");
            return;
        }

        Customer customer = new Customer();
        customer.name = name;
        customer.lastName = lastName;
        customer.phone = phone;

        viewModel.insertCustomer(customer);
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


 */