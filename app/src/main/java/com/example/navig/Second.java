package com.example.navig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView; // Import TextView
import androidx.fragment.app.Fragment;

public class Second extends Fragment {

    private static final String ARG_NAME = "name"; // Change to match your argument name
    private String mName;

    public Second() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);


        String name = SecondArgs.fromBundle(requireArguments()).getName();
        String telephone = SecondArgs.fromBundle(requireArguments()).getTelephone();
        String adres = SecondArgs.fromBundle(requireArguments()).getAdres();
        TextView textView = view.findViewById(R.id.textView);

        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);
       // textView.setText(name); // Set the retrieved name to the TextView
textView1.setText(name);
textView2.setText(telephone);
        return view;
    }
  /*  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = view.findViewById(R.id.textView); // Assuming you have a TextView in fragment_second layout
        textView.setText(mName); // Display the name in the TextView
        return view;
    }

   */
}
/*

package com.example.navig;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Second extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Second() {
        // Required empty public constructor
    }


    public static Second newInstance(String param1, String param2) {
        Second fragment = new Second();
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
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_second, container, false);
    }


}

*/
/*
        View view = inflater.inflate(R.layout.fragment_second, container,
                String name = Second.fromBundle(requireArguments())
                getMessage()
                )

 */