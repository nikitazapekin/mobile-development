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

            binding.editId.setError("ID is required for editing");
        }
    }


    private void deleteCustomer() {
        String idString = binding.editId.getText().toString().trim();

        if (!idString.isEmpty()) {
            long id = Long.parseLong(idString);

            Customer customer = new Customer();
            customer.id = id;


            viewModel.deleteCustomer(customer);


            getParentFragmentManager().popBackStack();
        } else {
            binding.editId.setError("ID is required for deleting");
        }
    }


    private void setupRecyclerView() {

    }

    private void setupViewModel() {

       viewModel = new ViewModelProvider(this).get(MainViewModel.class);
//  viewModel.getCustomers().observe(getViewLifecycleOwner(), adapter::submitList);
    }

    private void setupFab() {
        binding.editEditCustomer.setOnClickListener(v -> editCustomer());
     binding.editDeleteCustomer.setOnClickListener(v ->deleteCustomer());

    }

}
