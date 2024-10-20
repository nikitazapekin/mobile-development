package com.example.lab8;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class RecyclerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

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

        // Change from ListView to RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        List<Car> cars = Car.getCars();


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CarAdapterRecycleView.OnCarsClickListener carsClickListener = new CarAdapterRecycleView.OnCarsClickListener() {
            @Override
            public void onCarClick(Car car, int position) {
                Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();
            }

        };
        CarAdapterRecycleView adapter = new CarAdapterRecycleView(getActivity(), cars, carsClickListener);
        recyclerView.setAdapter(adapter);



        return view;
    }
}
