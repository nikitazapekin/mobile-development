package com.example.lab12test;




import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.viewbindingactivityfragment.R;
import com.example.viewbindingactivityfragment.databinding.FragmentHorseBinding;
import com.example.viewbindingactivityfragment.databinding.FragmentPersonalBinding;
import com.example.viewbindingactivityfragment.databinding.FragmentPurchaseDetailsBinding;
import com.example.viewbindingactivityfragment.databinding.FragmentPurchasesBinding;

import java.util.ArrayList;


public class PersonalFragment extends Fragment {
    private @NonNull FragmentPersonalBinding binding;

    private static final String ARG_CUSTOMER_ID = "customer_id";
    private long customerId;
    private HorseAdapter horseAdapter;


    private MainViewModel viewModel;

    public static PersonalFragment newInstance(long customerId) {
        PersonalFragment fragment = new  PersonalFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_CUSTOMER_ID, customerId);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            customerId = getArguments().getLong(ARG_CUSTOMER_ID);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPersonalBinding.inflate(inflater, container, false);

        setupRecyclerView();
        setupViewModel();
        //    setupFab();

        binding.btnSubmit.setOnClickListener(v -> updateCustomer());

        return binding.getRoot();
    }


    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        horseAdapter = new HorseAdapter(new ArrayList<>());  // Ensure it's initialized
        binding.recyclerView.setAdapter(horseAdapter);
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Make sure horseAdapter is initialized before setting the observer
        viewModel.getHorsesByOwner(customerId).observe(getViewLifecycleOwner(), horses -> {
            if (horseAdapter != null) {
                horseAdapter.setHorseList(horses);  // Safely set horse list
            }
        });
    }


/*
    private void setupRecyclerView() {
        //     binding.recyclerViewPurchases.setLayoutManager(new LinearLayoutManager(getContext()));
        //   adapter = new PurchaseAdapter(purchase -> openPurchaseDetails(purchase.id));
        //   binding.recyclerViewPurchases.setAdapter(adapter);
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }


 */
    /*
        private void setupFab() {
            binding.button2.setOnClickListener(v -> openAddPurchase());
        }

        private void openAddPurchase() {
            AddPurchaseFragment fragment = AddPurchaseFragment.newInstance(customerId);
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }

        private void openPurchaseDetails(long purchaseId) {
            PurchaseDetailsFragment fragment = PurchaseDetailsFragment.newInstance(purchaseId);
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    */



    private void updateCustomer() {
        String name = binding.etName.getText().toString().trim();
        String ageStr = binding.etAge.getText().toString().trim();
        String phone = binding.etPhone.getText().toString().trim();

        if (name.isEmpty() || ageStr.isEmpty() || phone.isEmpty()) {
            showErrorDialog("Пожалуйста, заполните все поля.");
            return;
        }

        // Преобразуем возраст в число
        int age = Integer.parseInt(ageStr);


        Human human = new Human();
        human.setId(customerId);
        human.setName(name);
        human.setAge(age);
        human.setPhone(phone);


        viewModel.updateHuman(human);
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

