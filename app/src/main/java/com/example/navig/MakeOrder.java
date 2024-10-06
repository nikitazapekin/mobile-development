package com.example.navig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class MakeOrder extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

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

        LinearLayout offersContainer = view.findViewById(R.id.offersContainer);
        LayoutInflater itemInflater = LayoutInflater.from(getContext());

        // Создаем список продуктов
        List<Product> productList = getProducts();

        // Добавляем каждую позицию в контейнер
        for (Product product : productList) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);

            // Устанавливаем изображение
            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());

            // Устанавливаем название
            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());

            // Устанавливаем цену
            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");

            offersContainer.addView(itemView);
        }

        return view;
    }

    // Метод для создания списка продуктов
    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();


       products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));

        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));

        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));

        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 200.0));


        // Добавьте больше товаров по необходимости

        return products;
    }
}


/*
package com.example.navig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MakeOrder extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

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

        LinearLayout offersContainer = view.findViewById(R.id.offersContainer);
        LayoutInflater itemInflater = LayoutInflater.from(getContext());


        for (int i = 0; i < 10; i++) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);


            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText("Название " + (i + 1));

            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена " + (i + 1) * 10 + " руб.");

            offersContainer.addView(itemView);
        }

        return view;
    }
}
*/