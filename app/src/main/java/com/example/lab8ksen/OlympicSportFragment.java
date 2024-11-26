package com.example.lab8ksen;

// package com.example.lab8ksen;

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

public class OlympicSportFragment extends Fragment {

    public OlympicSportFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_gragment, container, false);

        ListView lvMain = view.findViewById(R.id.lvMain);

        List<OlympicSport> sports = OlympicSport.getSports();
        ArrayAdapter<OlympicSport> adapter = new OlympicSportAdapter(getActivity(), R.layout.list_item, sports);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OlympicSport selectedSport = sports.get(position);
                Toast.makeText(
                        getActivity(),
                        "Clicked: " + selectedSport.getName(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        return view;
    }
}
