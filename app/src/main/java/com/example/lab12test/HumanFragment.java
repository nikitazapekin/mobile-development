package com.example.lab12test;





import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.viewbindingactivityfragment.R;
import com.example.viewbindingactivityfragment.databinding.FragmentHumanBinding;


public class HumanFragment extends Fragment {

    private FragmentHumanBinding binding;
    //private CustomerAdapter adapter;
    private MainViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHumanBinding.inflate(inflater, container, false);

        setupRecyclerView();
       // setupViewModel();
        setupFab();

        return binding.getRoot();
    }


    private void setupRecyclerView() {
       // binding.recyclerViewCustomers.setLayoutManager(new LinearLayoutManager(getContext()));

/*
        adapter = new CustomerAdapter(
                customer -> openPurchases(customer.getId()),
                customer -> {
                    viewModel.deleteCustomer(customer);

                }
        );

        binding.recyclerViewCustomers.setAdapter(adapter); */
    }

   /* private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getCustomers().observe(getViewLifecycleOwner(), adapter::submitList);
    }

    private void setupFab() {
        binding.button.setOnClickListener(v -> openAddCustomer());
        //binding.fabAddCustomer.setOnClickListener(v -> openAddCustomer());
    }

    private void openAddCustomer() {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new AddCustomerFragment())
                .addToBackStack(null)
                .commit();
    }

    private void openPurchases(long customerId) {
        PurchasesFragment fragment = PurchasesFragment.newInstance(customerId);
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
*/


    private void setupFab() {
        binding.button.setOnClickListener(v -> openAddParticipant());
        //binding.fabAddCustomer.setOnClickListener(v -> openAddCustomer());
    }
    private void openAddParticipant() {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new AddParticipantFragment())
                .addToBackStack(null)
                .commit();
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}