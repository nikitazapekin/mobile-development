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
import com.example.viewbindingactivityfragment.databinding.FragmentAddPurchaseBinding;


public class AddPurchaseFragment extends Fragment {

    private FragmentAddPurchaseBinding binding;
    private static final String ARG_CUSTOMER_ID = "customer_id";
    private long customerId;
    private MainViewModel viewModel;

    public static AddPurchaseFragment newInstance(long customerId) {
        AddPurchaseFragment fragment = new AddPurchaseFragment();
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
        binding = FragmentAddPurchaseBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnAddPurchase.setOnClickListener(v -> addPurchase());
        return binding.getRoot();
    }

    private void addPurchase() {
        String product = binding.etProduct.getText().toString().trim();
        String countStr = binding.etCount.getText().toString().trim();
        String priceStr = binding.etPrice.getText().toString().trim();



        if (product.isEmpty() || countStr.isEmpty() || priceStr.isEmpty()) {
            showErrorDialog("Пожалуйста, заполните все поля.");
            return;
        }


        int count;
        double price;


        try {
            count = Integer.parseInt(countStr);
            if (count <= 0) {
                showErrorDialog("Количество должно быть положительным числом.");
                return;
            }
        } catch (NumberFormatException e) {
            showErrorDialog("Количество должно быть целым числом.");
            return;
        }


        try {
            price = Double.parseDouble(priceStr);
            if (price <= 0) {
                showErrorDialog("Цена должна быть положительным числом.");
                return;
            }
        } catch (NumberFormatException e) {
            showErrorDialog("Цена должна быть числом.");
            return;
        }


        Purchase purchase = new Purchase();
        purchase.product = product;
        purchase.count = Integer.parseInt(countStr);
        purchase.price = Double.parseDouble(priceStr);
        purchase.customerId = customerId;

   //     viewModel.insertPurchase(purchase);
        getParentFragmentManager().popBackStack();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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