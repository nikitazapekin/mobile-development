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

        // Пример добавления товаров (замените реальные ресурсы изображений и данные)
     //   products.add(new Product("data:image/jpeg;base64,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", "Товар 1", 100.0));
        //   products.add(new Product(, "Товар 2", 150.0));
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