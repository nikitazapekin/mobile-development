package com.example.lab8;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;




import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.appbar.MaterialToolbar;


import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.util.Log;
public class ListVFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "ListVFragment";

    private String mParam1;
    private String mParam2;

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


        ListView lvMain = (ListView) view.findViewById(R.id.lvMain);


        List<Car> cars = Car.getCars();
ArrayAdapter<Car> adapter = new CarAdapter(getActivity(), R.id.lvMain, cars);
lvMain.setAdapter(adapter);


        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Clicked " + position + ", id " + id, Toast.LENGTH_SHORT).show();

                Log.d(TAG, "Clicked " + position + ", id " + id);
            }


            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });



        return view;

    }


}