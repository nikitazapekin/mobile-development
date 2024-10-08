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

        LayoutInflater itemInflater = LayoutInflater.from(getContext());

        String name = SecondArgs.fromBundle(requireArguments()).getName();
        String telephone = SecondArgs.fromBundle(requireArguments()).getTelephone();
        String adres = SecondArgs.fromBundle(requireArguments()).getAdres();

        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

        textView1.setText(name);
        textView2.setText(telephone);

        List<Product> productList = getProducts();

        for (Product product : productList) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);

            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());

            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());

            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");

            // Добавление обработчика нажатия на радио-кнопку
            RadioButton radioButton = itemView.findViewById(R.id.radioButton);
            radioButton.setTag(product); // Сохраняем объект продукта в качестве тега

            offersContainer.addView(itemView);
        }

        // Обработка нажатия на кнопку "Выбрать"
        selectButton.setOnClickListener(v -> {
            addSelectedOffers();
        });

        return view;
    }

    private void addSelectedOffers() {
        // Получаем количество дочерних элементов в offersContainer
        int childCount = offersContainer.getChildCount();
        boolean hasSelected = false;

        for (int i = 0; i < childCount; i++) {
            View itemView = offersContainer.getChildAt(i);
            RadioButton radioButton = itemView.findViewById(R.id.radioButton);

            // Если радио-кнопка выбрана, добавляем продукт в bookedOffersContainer
         //   if (radioButton.isChecked()) {
            if (radioButton != null && radioButton.isChecked()) {
                Product product = (Product) radioButton.getTag(); // Получаем продукт из тега

                // Создаём новый элемент для забронированных предложений
                View bookedItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_order, bookedOffersContainer, false);
                ImageView bookedItemImage = bookedItemView.findViewById(R.id.itemImage);
                bookedItemImage.setImageResource(product.getImageResId());

                TextView bookedItemName = bookedItemView.findViewById(R.id.itemName);
                bookedItemName.setText(product.getName());

                TextView bookedItemPrice = bookedItemView.findViewById(R.id.itemPrice);
                bookedItemPrice.setText("Цена: " + product.getPrice() + " руб.");

                bookedOffersContainer.addView(bookedItemView);
                hasSelected = true; // Указываем, что есть выбранные элементы
            }
        }

        // Управление видимостью текста о забронированных предложениях
        if (hasSelected) {
            emptyBookedOffers.setVisibility(View.GONE); // Скрываем текст
        } else {
            emptyBookedOffers.setVisibility(View.VISIBLE); // Показываем текст
            Toast.makeText(getContext(), "Пожалуйста, выберите хотя бы один элемент", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        // Добавляем товары
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 1", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 2", 300.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 150.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 4", 250.0));
        return products;
    }
}


/*
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
import java.util.List;

public class MakeOrder extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private List<Product> productList; // Список товаров
    private List<Product> selectedProducts; // Список выбранных товаров

    public MakeOrder() {
        selectedProducts = new ArrayList<>(); // Инициализируем список выбранных товаров
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

        String name = SecondArgs.fromBundle(requireArguments()).getName();
        String telephone = SecondArgs.fromBundle(requireArguments()).getTelephone();
        String adres = SecondArgs.fromBundle(requireArguments()).getAdres();

        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

        textView1.setText(name);
        textView2.setText(telephone);

        productList = getProducts(); // Получаем список продуктов

        for (Product product : productList) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);

            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());

            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());

            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");

            RadioButton radioButton = itemView.findViewById(R.id.radioButton);
            radioButton.setOnClickListener(v -> {
                if (radioButton.isChecked()) {
                    selectedProducts.add(product); // Добавляем товар в список выбранных
                } else {
                    selectedProducts.remove(product); // Убираем товар из списка, если он был снят
                }
            });

            offersContainer.addView(itemView);
        }

        Button selectButton = view.findViewById(R.id.button2);
        selectButton.setOnClickListener(v -> {
            if (selectedProducts.isEmpty()) {
                Toast.makeText(getContext(), "Нет выбранных товаров", Toast.LENGTH_SHORT).show();
            } else {
                StringBuilder selectedNames = new StringBuilder("Выбрано: ");
                for (Product selectedProduct : selectedProducts) {
                    selectedNames.append(selectedProduct.getName()).append(", ");
                }
                // Удаляем последнюю запятую и пробел
                selectedNames.setLength(selectedNames.length() - 2);
                Toast.makeText(getContext(), selectedNames.toString(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 1", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 2", 300.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 150.0));
        // Добавьте другие товары по необходимости

        return products;
    }
}
*/

/*
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



        String name = SecondArgs.fromBundle(requireArguments()).getName();
        String telephone = SecondArgs.fromBundle(requireArguments()).getTelephone();
        String adres = SecondArgs.fromBundle(requireArguments()).getAdres();

        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

        textView1.setText(name);
        textView2.setText(telephone);




        List<Product> productList = getProducts();

        for (Product product : productList) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);


            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());


            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());


            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");

            offersContainer.addView(itemView);
        }

        return view;
    }





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




        return products;
    }
}
*/
/*
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
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;
public class MakeOrder extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private LinearLayout bookedOffersContainer;

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
        bookedOffersContainer = view.findViewById(R.id.bookedOffersContainer);
        LayoutInflater itemInflater = LayoutInflater.from(getContext());

        String name = SecondArgs.fromBundle(requireArguments()).getName();
        String telephone = SecondArgs.fromBundle(requireArguments()).getTelephone();
        String address = SecondArgs.fromBundle(requireArguments()).getAdres();

        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

        textView1.setText(name);
        textView2.setText(telephone);

        List<Product> productList = getProducts();

        for (Product product : productList) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);

            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());

            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());

            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");

            // Добавляем радиокнопку
            RadioButton radioButton = itemView.findViewById(R.id.radioButton);
            if (radioButton != null) {
                radioButton.setId(View.generateViewId()); // Генерируем уникальный ID для каждой радиокнопки
            }

            offersContainer.addView(itemView);
        }

        Button selectButton = view.findViewById(R.id.button2);
     //   Button selectButton = view.findViewById(R.id.listOfOffers);
        selectButton.setOnClickListener(v -> addSelectedOffers(offersContainer));

        return view;
    }
    private void addSelectedOffers(LinearLayout offersContainer) {
        for (int i = 0; i < offersContainer.getChildCount(); i++) {
            View itemView = offersContainer.getChildAt(i);
            RadioButton radioButton = itemView.findViewById(R.id.radioButton);

            if (radioButton != null && radioButton.isChecked()) {
                // Получаем изображение и текст товара
                ImageView itemImage = itemView.findViewById(R.id.itemImage);
                String itemName = ((TextView) itemView.findViewById(R.id.itemName)).getText().toString();
                String itemPrice = ((TextView) itemView.findViewById(R.id.itemPrice)).getText().toString();

                // Логируем информацию о добавляемом товаре
                Log.d("MakeOrder", "Adding selected offer: " + itemName + " - " + itemPrice);

                // Создаем новый элемент для выбранного товара
                View bookedItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_order, bookedOffersContainer, false);
                ImageView bookedItemImage = bookedItemView.findViewById(R.id.itemImage);
                bookedItemImage.setImageDrawable(itemImage.getDrawable());
                ((TextView) bookedItemView.findViewById(R.id.itemName)).setText(itemName);
                ((TextView) bookedItemView.findViewById(R.id.itemPrice)).setText(itemPrice);

                bookedOffersContainer.addView(bookedItemView);
            }
        }
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 1", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 2", 250.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 3", 300.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 4", 150.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Товар 5", 180.0));
        return products;
    }
}
*/
/*
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



        String name = SecondArgs.fromBundle(requireArguments()).getName();
        String telephone = SecondArgs.fromBundle(requireArguments()).getTelephone();
        String adres = SecondArgs.fromBundle(requireArguments()).getAdres();

        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

        textView1.setText(name);
        textView2.setText(telephone);




        List<Product> productList = getProducts();

        for (Product product : productList) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);


            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());


            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());


            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");

            offersContainer.addView(itemView);
        }

        return view;
    }





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




        return products;
    }
}
*/