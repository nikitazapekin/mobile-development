package com.example.lab8ksen;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class RecycleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RecycleFragment() {

    }

    public static RecycleFragment newInstance(String param1, String param2) {
        RecycleFragment fragment = new RecycleFragment();
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

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        List<OlympicSport> sports = OlympicSport.getSports();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    RecycleViewAdapter.OnSportsClickListener sportClickListener = new RecycleViewAdapter.OnSportsClickListener() {
            @Override
            public void onSportClick(OlympicSport sport, int position) {
                Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();
                handleredirect(view, sport, position);
            }
        };



     RecycleViewAdapter adapter = new RecycleViewAdapter(getActivity(), sports, sportClickListener);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void handleredirect(View v, OlympicSport car, int index) {
     /*   String name = car.getName();
        String fullDecribtion = car.getFullDescribtion();
        String describtion = car.getDescribtion();
        String price= String.valueOf(car.getPrice());
        int imageResId = car.getLogo();

        RecycleFragmentDirections.ActionRecyclerFragmentToDetailFragment action =
                RecycleFragmentDirections.actionRecyclerFragmentToDetailFragment(name, fullDecribtion, describtion, price, imageResId);
        Navigation.findNavController(v).navigate(action);

      */
    }
}