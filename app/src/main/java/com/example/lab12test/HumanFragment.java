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
import com.example.viewbindingactivityfragment.databinding.FragmentHumanBinding;


public class HumanFragment extends Fragment {

    private FragmentHumanBinding binding;
   private HumanAdapter adapter;
    private MainViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHumanBinding.inflate(inflater, container, false);

        setupRecyclerView();
        setupViewModel();
        setupFab();

        return binding.getRoot();
    }


    private void setupRecyclerView() {
     binding.recyclerViewHuman.setLayoutManager(new LinearLayoutManager(getContext()));



        adapter = new HumanAdapter(
              human -> openPersonal(human.getId()),
              human -> {
                    viewModel.deleteHuman(human);

                }
        );




        binding.recyclerViewHuman.setAdapter(adapter);

    }

 private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getHumans().observe(getViewLifecycleOwner(), adapter::submitList);
    }


    private void setupFab() {
        binding.button.setOnClickListener(v -> openAddParticipant());
        binding.button1.setOnClickListener(v -> openAddHorse());

    }
    private void openAddParticipant() {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new AddParticipantFragment())
                .addToBackStack(null)
                .commit();
    }
    private void openAddHorse() {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new HorseFragment())
                .addToBackStack(null)
                .commit();
    }



    private void openPersonal(long customerId) {
        //  HorseFragment  fragment =HorseFragment.newInstance(customerId);
        PersonalFragment fragment =PersonalFragment.newInstance(customerId);
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