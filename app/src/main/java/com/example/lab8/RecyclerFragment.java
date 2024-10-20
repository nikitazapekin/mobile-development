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
        // Required empty public constructor
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

        // Set the LayoutManager and Adapter for RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CarAdapterRecycleView adapter = new CarAdapterRecycleView(getActivity(), cars);
        recyclerView.setAdapter(adapter);

        // If you want to set click listeners for items, you can do that in the adapter itself.
        // Alternatively, use the following approach to set a click listener for the whole view:
    /*    adapter.setOnItemClickListener(new CarAdapterRecycleView.OnItemClickListener() {

            public void onItemClick(int position) {
                Toast.makeText(getActivity(), "Clicked " + position, Toast.LENGTH_SHORT).show();
            }
        }); */

        return view;
    }
}

/*
package com.example.lab8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;




public class RecyclerFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public RecyclerFragment() {
        // Required empty public constructor
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
        ListView lvMain = (ListView) view.findViewById(R.id.recycler_view);


        List<Car> cars = Car.getCars();
        ArrayAdapter<Car> adapter = new CarAdapter(getActivity(), R.id.recycler_view, cars);
        lvMain.setAdapter(adapter);


        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Clicked " + position + ", id " + id, Toast.LENGTH_SHORT).show();
            }


            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });



        return view;


    }
}
*/