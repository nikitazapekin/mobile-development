package com.example.lab_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ListView;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
public class third extends Fragment {

    private ListView listView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public third() {

    }


    public static third newInstance(String param1, String param2) {
        third fragment = new third();
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
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);

        listView = rootView.findViewById(R.id.listView);


        List<Work> works = new ArrayList<>();
        works.add(new Work("Руслан и Людмила", "1820"));
        works.add(new Work("Кавказский пленник", "1821"));
        works.add(new Work("Борис Годунов", "1825"));

        works.add(new Work("Повести Белкина", "1830"));
        works.add(new Work("Кавказский пленник", "1821"));
        works.add(new Work("Маленькие трагедии", "1830"));

        works.add(new Work("Пиковая дама", "1833"));
        works.add(new Work("Медный всадник", "1833"));
        works.add(new Work("Капитанская дочка", "1836"));


        works.add(new Work("Капитанская дочка", "1836"));

        WorkAdapter adapter = new WorkAdapter(getContext(), works);
        listView.setAdapter(adapter);

        return rootView;
    }




}



