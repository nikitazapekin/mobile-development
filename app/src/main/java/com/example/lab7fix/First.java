package com.example.lab7fix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link First#newInstance} factory method to
 * create an instance of this fragment.
 */
public class First extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public First() {
        // Required empty public constructor
    }


    public static First newInstance(String param1, String param2) {
        First fragment = new First();
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

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRedirect(view);
            }


        });


        return view;
      //  return inflater.inflate(R.layout.fragment_first, container, false);
    }


    void handleRedirect(View v) {


            Navigation.findNavController(v).navigate(R.id.action_first_to_second);

        //  RecyclerFragmentDirections.ActionRecyclerFragmentToDetailFragment action =
        //        RecyclerFragmentDirections.actionRecyclerFragmentToDetailFragment(name, fullDecribtion, describtion, price, imageResId);
        //Navigation.findNavController(v).navigate(action);
    }
}