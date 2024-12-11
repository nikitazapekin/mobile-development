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
   //     binding.recyclerViewPurchases.setLayoutManager(new LinearLayoutManager(getContext()));
     //   adapter = new PurchaseAdapter(purchase -> openPurchaseDetails(purchase.id));
     //   binding.recyclerViewPurchases.setAdapter(adapter);
    }

    private void setupViewModel() {
      //  viewModel = new ViewModelProvider(this).get(MainViewModel.class);
     //   viewModel.getPurchasesByCustomer(customerId).observe(getViewLifecycleOwner(), adapter::submitList);
    }
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
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

/*
package com.example.lab12test;

public class HorseFragment {
}
*/