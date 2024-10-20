package com.example.lab8;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.appbar.MaterialToolbar;


public class ListVFragment extends Fragment {

   String[] names = {
           "Test",
           "Test",
           "Test",
           "Test",
           "Test",
           "Test",
           "Test",
   };
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ListVFragment() {
        // Required empty public constructor
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

        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity appCompatActivity = ((AppCompatActivity)getActivity());
        if(appCompatActivity!=null) {
            appCompatActivity.setSupportActionBar(toolbar);
        }
        ListView lvMain = (ListView) view.findViewById(R.id.lvMain);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, names);
        lvMain.setAdapter(adapter);


        return view;
       // return inflater.inflate(R.layout.list_gragment, container, false);
    }
}