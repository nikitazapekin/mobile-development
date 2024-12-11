package com.example.lab12test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

        if (name.isEmpty() || ageStr.isEmpty() || ownerIdStr.isEmpty()) {
            Toast.makeText(getContext(), "Пожалуйста, заполните все поля.", Toast.LENGTH_SHORT).show();
            return;
        }

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.viewbindingactivityfragment.R;
import com.example.viewbindingactivityfragment.databinding.FragmentHorseBinding;
import com.example.viewbindingactivityfragment.databinding.FragmentPurchaseDetailsBinding;
import com.example.viewbindingactivityfragment.databinding.FragmentPurchasesBinding;


public class HorseFragment extends Fragment {
    private @NonNull FragmentHorseBinding binding;

    private static final String ARG_CUSTOMER_ID = "customer_id";
    private long customerId;

    private PurchaseAdapter adapter;
    private MainViewModel viewModel;

    public static  HorseFragment newInstance(long customerId) {
        HorseFragment fragment = new  HorseFragment();
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
        binding = FragmentHorseBinding.inflate(inflater, container, false);

        setupRecyclerView();
        setupViewModel();
    //    setupFab();

        return binding.getRoot();
    }



    private void setupRecyclerView() {

    }

    private void setupViewModel() {

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
*/