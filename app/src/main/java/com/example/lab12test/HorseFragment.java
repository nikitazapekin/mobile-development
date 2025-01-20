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


public class HorseFragment extends Fragment {
private @NonNull FragmentHorseBinding binding;

    private static final String ARG_HUMAN_ID = "human_id";
    private long humanId;

    private HorseAdapter adapter;
    private MainViewModel viewModel;

    public static HorseFragment newInstance(long customerId) {
        HorseFragment fragment = new HorseFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_HUMAN_ID, customerId);
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
        binding = FragmentHorseBinding.inflate(inflater, container, false);

        setupRecyclerView();
        setupViewModel();
        setupFab();

        return binding.getRoot();
    }



    private void setupRecyclerView() {
        binding.recyclerViewPurchases.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HorseAdapter(purchase -> openHorseDetails(purchase.id));
        binding.recyclerViewPurchases.setAdapter(adapter);
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getHorseByHuman(humanId).observe(getViewLifecycleOwner(), adapter::submitList);
    }

    private void setupFab() {
        binding.button2.setOnClickListener(v -> openAddHorse());
    }

    private void openAddHorse() {
        AddHorseFragment fragment = AddHorseFragment.newInstance(humanId);
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void openHorseDetails(long purchaseId) {
        HorseDetailsFragment fragment = HorseDetailsFragment.newInstance(purchaseId);
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}