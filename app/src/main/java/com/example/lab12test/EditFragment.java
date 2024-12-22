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



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditBinding.inflate(inflater, container, false);

        setupRecyclerView();
        setupViewModel();
        setupFab();

        return binding.getRoot();
    }



    private void setupRecyclerView() {
    /*    binding.recyclerViewCustomers.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter = new CustomerAdapter(
                customer -> openPurchases(customer.getId()),
                customer -> {
                    viewModel.deleteCustomer(customer);

                }
        );

        binding.recyclerViewCustomers.setAdapter(adapter);

     */
    }

    private void setupViewModel() {
    //    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
     //   viewModel.getCustomers().observe(getViewLifecycleOwner(), adapter::submitList);
    }

    private void setupFab() {
    //    binding.button.setOnClickListener(v -> openAddCustomer());
        //binding.fabAddCustomer.setOnClickListener(v -> openAddCustomer());
    }

}
