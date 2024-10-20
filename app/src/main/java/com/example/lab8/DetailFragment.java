package com.example.lab8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private String fullDescribtion;
    public DetailFragment() {

    }


    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
   /*     SecondArgs args = SecondArgs.fromBundle(getArguments());
        //  MakeOrderArgs argsOrder = MakeOrderArgs.fromBundle(getArguments());

        name = args.getName();
        tel = args.getTelephone();
        adres = args.getAdres();

        items = args.getSavedItem(); */
        DetailFragmentArgs args =    DetailFragmentArgs.fromBundle(getArguments());
        fullDescribtion = args.getFullDescribtion();
     //   return inflater.inflate(R.layout.detail_fragment, container, false);
        return view;
    }
}