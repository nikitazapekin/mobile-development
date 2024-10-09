package com.example.navig;

import android.util.Log;
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
import java.util.Arrays;
import androidx.navigation.Navigation;

public class MakeOrder extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private LinearLayout offersContainer;
    private LinearLayout bookedOffersContainer;
    private TextView emptyBookedOffers;

    private List<Product> allProducts = new ArrayList<>();
    private List<String> stored = new ArrayList<>();

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

            stored.addAll(Arrays.asList(MakeOrderArgs.fromBundle(getArguments()).getSavedItem()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_make_order, container, false);

        offersContainer = view.findViewById(R.id.offersContainer);
        bookedOffersContainer = view.findViewById(R.id.bookedOffersContainer);
    //    emptyBookedOffers = view.findViewById(R.id.emptyBookedOffers);
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

        allProducts = getProducts();
        Log.d("SecondFragment", "all: " + allProducts);

        for (Product product : allProducts) {
            View itemView = itemInflater.inflate(R.layout.item_order, offersContainer, false);

            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(product.getImageResId());

            TextView itemName = itemView.findViewById(R.id.itemName);
            itemName.setText(product.getName());

            TextView itemPrice = itemView.findViewById(R.id.itemPrice);
            itemPrice.setText("Цена: " + product.getPrice() + " руб.");

            RadioButton radioButton = itemView.findViewById(R.id.radioButton);
            radioButton.setTag(product);

            if (stored.contains(product.getName())) {
                //    radioButton.setEnabled(false);
            }

            offersContainer.addView(itemView);
        }

        displaySavedProducts();

        selectButton.setOnClickListener(v -> addSelectedOffers());

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

                String[] itemsArray = stored.toArray(new String[0]);
                Toast.makeText(getContext(), "Выбранные элементы: " + Arrays.toString(itemsArray), Toast.LENGTH_SHORT).show();

                MakeOrderDirections.ActionMakeOrderToSecond action = MakeOrderDirections.actionMakeOrderToSecond(itemsArray, tel, adres, name);
                Navigation.findNavController(v).navigate(action);

                Toast.makeText(getContext(), "Заказ готовится!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Пожалуйста, выберите хотя бы один элемент", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
private void displaySavedProducts() {
    bookedOffersContainer.removeAllViews();
    if (!stored.isEmpty()) {
   //     emptyBookedOffers.setVisibility(View.GONE);
        for (String product : stored) {
            View bookedItemView = LayoutInflater.from(getContext()).inflate(R.layout.booked__item, bookedOffersContainer, false);

            TextView bookedItemName = bookedItemView.findViewById(R.id.itemName);
            bookedItemName.setText(product);


            bookedOffersContainer.addView(bookedItemView);
        }
    } else {
  //     emptyBookedOffers.setVisibility(View.VISIBLE);
    }
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

                TextView bookedItemName = bookedItemView.findViewById(R.id.itemName);
                bookedItemName.setText(product.getName());



                bookedOffersContainer.addView(bookedItemView);
           //     radioButton.setEnabled(false);
                stored.add(product.getName());

                hasSelected = true;
            }
        }

        if (hasSelected) {
      //     emptyBookedOffers.setVisibility(View.GONE);
        } else {
     //   emptyBookedOffers.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "Пожалуйста, выберите хотя бы один элемент", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(R.drawable.free_icon_pizza_706934, "Моцарела", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Пиперони", 300.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Чили", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Обычная", 300.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Испанская", 200.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Грибная", 300.0));
        products.add(new Product(R.drawable.free_icon_pizza_706934, "Чили", 200.0));


        return products;
    }
}
