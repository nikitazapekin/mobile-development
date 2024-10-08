package com.example.navig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import androidx.navigation.Navigation;
import java.util.List;

public class MakeOrder extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private LinearLayout offersContainer;
    private LinearLayout bookedOffersContainer;
    private TextView emptyBookedOffers;

    public MakeOrder() {
    }

    public static MakeOrder newInstance(String param1, String param2) {
        MakeOrder fragment = new MakeOrder();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make_order, container, false);

        offersContainer = view.findViewById(R.id.offersContainer);
        bookedOffersContainer = view.findViewById(R.id.bookedOffersContainer);
        emptyBookedOffers = view.findViewById(R.id.emptyBookedOffers);
        Button selectButton = view.findViewById(R.id.button2);
        Button bookButton = view.findViewById(R.id.bookBtn);


        LayoutInflater itemInflater = LayoutInflater.from(getContext());

        String name = SecondArgs.fromBundle(requireArguments()).getName();
        String tel = SecondArgs.fromBundle(requireArguments()).getTelephone();
        String adres = SecondArgs.fromBundle(requireArguments()).getAdres();

        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

        textView1.setText(name);
        textView2.setText(tel);

        List<Product> productList = getProducts();

        for (Product product : productList) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);

            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());

            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());

            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");


            RadioButton radioButton = itemView.findViewById(R.id.radioButton);
            radioButton.setTag(product);

            offersContainer.addView(itemView);
        }

        selectButton.setOnClickListener(v -> {
            addSelectedOffers();
        });


        bookButton.setOnClickListener(v -> {
            List<String> selectedItems = new ArrayList<>();

            for (int i = 0; i < offersContainer.getChildCount(); i++) {
                View itemView = offersContainer.getChildAt(i);
                RadioButton radioButton = itemView.findViewById(R.id.radioButton);

                if (radioButton != null && radioButton.isChecked()) {
                    Product product = (Product) radioButton.getTag();
                    selectedItems.add(product.getName());
                }
            }

            if (!selectedItems.isEmpty()) {
                String[] itemsArray = selectedItems.toArray(new String[0]);

                MakeOrderDirections.ActionMakeOrderToSecond action = MakeOrderDirections.actionMakeOrderToSecond(itemsArray, tel, adres, name);
                Navigation.findNavController(v).navigate(action);

                Toast.makeText(getContext(), "Заказ готовится!", Toast.LENGTH_SHORT).show();
             //   Toast.makeText(getContext(), itemsArray, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Пожалуйста, выберите хотя бы один элемент", Toast.LENGTH_SHORT).show();
            }
        });







        return view;
    }

    private void addSelectedOffers() {

        int childCount = offersContainer.getChildCount();
        boolean hasSelected = false;

        for (int i = 0; i < childCount; i++) {
            View itemView = offersContainer.getChildAt(i);
            RadioButton radioButton = itemView.findViewById(R.id.radioButton);


            if (radioButton != null && radioButton.isChecked()) {
                Product product = (Product) radioButton.getTag();

                View bookedItemView = LayoutInflater.from(getContext()).inflate(R.layout.booked__item, bookedOffersContainer, false);

                ImageView bookedItemImage = bookedItemView.findViewById(R.id.itemImage);
                bookedItemImage.setImageResource(product.getImageResId());

                TextView bookedItemName = bookedItemView.findViewById(R.id.itemName);
                bookedItemName.setText(product.getName());

                TextView bookedItemPrice = bookedItemView.findViewById(R.id.itemPrice);
                bookedItemPrice.setText("Цена: " + product.getPrice() + " руб.");

                ImageView deleteButton = bookedItemView.findViewById(R.id.imageView3);
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bookedOffersContainer.removeView(bookedItemView);

                        if (bookedOffersContainer.getChildCount() == 0) {

                            emptyBookedOffers.setVisibility(View.VISIBLE);
                        }
                    }
                });

                bookedOffersContainer.addView(bookedItemView);
                hasSelected = true;
            }
        }


        if (hasSelected) {
            emptyBookedOffers.setVisibility(View.GONE);
        } else {
            emptyBookedOffers.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "Пожалуйста, выберите хотя бы один элемент", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 1", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 2", 300.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 150.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 4", 250.0));
        return products;
    }
}

