package com.example.lab9;



import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "RecyclerFragment";
    private String mParam1;
    private String mParam2;



    private Car car;

    private String name;
    private String fullDescribtion;
    private byte  price;
    private String describtion;
    private  int imageResId;
    TextView titleText;
    TextView describtionText;
    TextView priceText;
    TextView fulldescribtionText;
    ImageView imageView;
    public RecyclerFragment() {

    }

    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
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
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);





        titleText = view.findViewById(R.id.textView5);
        describtionText = view.findViewById(R.id.textView2);
        priceText = view.findViewById(R.id.textView3);
        fulldescribtionText = view.findViewById(R.id.textView4);
        imageView = view.findViewById(R.id.image);



        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        List<Car> cars = Car.getCars();


        int orientation = getResources().getConfiguration().orientation;


        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        }


        CarsViewModel viewModel = new ViewModelProvider(this).get(CarsViewModel.class);

        car = viewModel.getCurrentCar();


        Car initialCar = viewModel.getCurrentCar();
        if (initialCar != null) {
            updateUI(initialCar);
        } else {
            Log.w(TAG, "No initial car set in ViewModel");
        }



        if(viewModel.loadCarName()!=null && viewModel.loadCarDescription()!=null &&   viewModel.loadCarFullDescription()!= null ) {

            titleText.setText(viewModel.loadCarName());
            describtionText.setText(viewModel.loadCarDescription());
            fulldescribtionText.setText(viewModel.loadCarFullDescription());
            priceText.setText(viewModel.loadCarPrice()+"$");
            imageView.setImageResource(viewModel.loadCarLogo());
        }




        CarAdapterRecycleView.OnCarsClickListener carsClickListener = new CarAdapterRecycleView.OnCarsClickListener() {
            @Override
            public void onCarClick(Car car, int position) {
                Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();





                Car selectedCar = cars.get(position);
                name = selectedCar.getName();
                describtion = selectedCar.getDescribtion();
                fullDescribtion = selectedCar.getFullDescribtion();
                imageResId = selectedCar.getLogo();
                price = selectedCar.getPrice();



                titleText.setText(name);
                describtionText.setText(describtion);
                priceText.setText(price + "$");
                fulldescribtionText.setText( fullDescribtion);



                imageView.setImageResource(imageResId);

                viewModel.setCurrentCar(selectedCar);




                updateUI(selectedCar);

            }
        };

        CarAdapterRecycleView adapter = new CarAdapterRecycleView(getActivity(), cars, carsClickListener);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void updateUI(Car car) {
        titleText.setText(car.getName());
        describtionText.setText(car.getDescribtion());
        priceText.setText(car.getPrice() + "$");
        fulldescribtionText.setText(car.getFullDescribtion());
        imageView.setImageResource(car.getLogo());
    }



}

/* ЛАЙВ ДАТА
package com.example.lab9;



import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;





    private String name;
    private String fullDescribtion;
    private byte  price;
    private String describtion;
    private  int imageResId;
    TextView titleText;
    TextView describtionText;
    TextView priceText;
    TextView fulldescribtionText;
    ImageView imageView;
    public RecyclerFragment() {

    }

    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
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

        DataController dataController = DataController.getInstance();

        dataController.getDataScreen2().observe(this, new Observer<Car>() {
            @Override
            public void onChanged(@Nullable Car car) {
                if (car != null) {
                    updateUI(car);
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);





        titleText = view.findViewById(R.id.textView5);
        describtionText = view.findViewById(R.id.textView2);
        priceText = view.findViewById(R.id.textView3);
        fulldescribtionText = view.findViewById(R.id.textView4);
        imageView = view.findViewById(R.id.image);



        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        List<Car> cars = Car.getCars();


        int orientation = getResources().getConfiguration().orientation;


        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        }






        CarAdapterRecycleView.OnCarsClickListener carsClickListener = new CarAdapterRecycleView.OnCarsClickListener() {
            @Override
            public void onCarClick(Car car, int position) {
                Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();





                Car selectedCar = cars.get(position);
                name = selectedCar.getName();
                describtion = selectedCar.getDescribtion();
                fullDescribtion = selectedCar.getFullDescribtion();
                imageResId = selectedCar.getLogo();
                price = selectedCar.getPrice();



                titleText.setText(name);
                describtionText.setText(describtion);
                priceText.setText(price + "$");
                fulldescribtionText.setText( fullDescribtion);



                imageView.setImageResource(imageResId);



                DataController.getInstance().setDataForScreen2(selectedCar);


                updateUI(selectedCar);

            }
        };

        CarAdapterRecycleView adapter = new CarAdapterRecycleView(getActivity(), cars, carsClickListener);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void updateUI(Car car) {
        titleText.setText(car.getName());
        describtionText.setText(car.getDescribtion());
        priceText.setText(car.getPrice() + "$");
        fulldescribtionText.setText(car.getFullDescribtion());
        imageView.setImageResource(car.getLogo());
    }



}
*/