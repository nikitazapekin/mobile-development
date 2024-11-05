package com.example.lab9;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;



import android.util.Log;
public class ListVFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "ListVFragment";

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
    public ListVFragment() {

    }




    public static ListVFragment newInstance(String param1, String param2) {
        ListVFragment fragment = new ListVFragment();
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
        View view = inflater.inflate(R.layout.list_gragment, container, false);



        titleText = view.findViewById(R.id.textView5);
        describtionText = view.findViewById(R.id.textView2);
       priceText = view.findViewById(R.id.textView3);
        fulldescribtionText = view.findViewById(R.id.textView4);
        imageView = view.findViewById(R.id.image);


        ListView lvMain = (ListView) view.findViewById(R.id.lvMain);


        List<Car> cars = Car.getCars();
        ArrayAdapter<Car> adapter = new CarAdapter(getActivity(), R.id.lvMain, cars);
        lvMain.setAdapter(adapter);


        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Clicked: " + id , Toast.LENGTH_SHORT).show();


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




                Log.d(TAG, "id " + id);
            }


            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });



        return view;

    }



/*
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Handle landscape layout if needed
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Handle portrait layout if needed
        }
    }
*/


}