package com.example.lab8;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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


    /*    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, names);
        lvMain.setAdapter(adapter); */


     /*   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names,
                android.R.layout.simple_list_item_single_choice);
        );
*/
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.names, android.R.layout.simple_list_item_single_choice);
        lvMain.setAdapter(adapter);


        /*
lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    showToast(getActivity(), "Clicked "+ position+ ", id "+id )    ;
    }
    public void onNothingSelected(AdapterView<?> parent) {
        showToast(getActivity(), "Nothing selected" )    ;
    }
});
*/

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
       // return inflater.inflate(R.layout.list_gragment, container, false);
    }
}