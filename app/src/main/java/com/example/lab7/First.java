package com.example.lab7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;



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


        View view  = inflater.inflate(R.layout.fragment_first, container, false);
        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//fab.setTooltipText("send");
        FloatingActionButton fab = view.findViewById(R.id.fab);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            fab.setTooltipText("send");
        }



        //       new StartGameDialogFragment().show(First.this.getActivity()
          //      .getSupportFragmentManager(), "GAME_DIALOG");
        if (getActivity() != null) {
            new StartGameDialogFragment().show(getActivity().getSupportFragmentManager(), "GAME_DIALOG");
        }


        return view;
    }



public static  class StartGameDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_start_game)
                .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Действие при нажатии "Start"
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Действие при нажатии "Cancel"
                    }
                });
        return builder.create();
    }
}
}
/* ПЕРВАЯ ЧАСТЬ
package com.example.lab7;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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


        View view  = inflater.inflate(R.layout.fragment_first, container, false);
        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup pizzaGroup =view.findViewById(R.id.pizza_group) ;
                int pizzaType = pizzaGroup.getCheckedRadioButtonId() ;
                if (pizzaType == -1) {
                    Toast.makeText(getActivity(),  "Heo6xogumo BbiOpaTb nuuuy",
                    Toast.LENGTH_SHORT).show() ;
                } else {
                    String order ="";
                    if (pizzaType == R. id.radio_margarita) {

                        //        }

                        order = "Muuyya \"Mapraputa\"";
                    }
else if (pizzaType == R.id.radio_peperoni) {


                        order = "Muuya \"Menneponu\"";
                    }
                else if (pizzaType == R.id.radio_barbeku) {
                        order = "Muyya \"Bap6exw\"";
                    }
                Chip cheeseBort = view. findViewById(R.id.cheese_bort);
                order += cheeseBort.isChecked()? " mic cbipHbiii Gopt" : "";
                Chip mozarelaMini = view.findViewById(R.id.mozarella_mini);



                        order += mozarelaMini.isChecked() ? " mnoc mouapenna-mini" : "ed";

                        Snackbar.make( fab, order, Snackbar.LENGTH_LONG).show();

            }
        }
    });


        return view;
    }


    private void handleredirect(View v) {

     //   FirstDire
     //  FirstDirections.ActionFirstToThird action = FirstDirections.actionFirstToThird();
     //  Navigation.findNavController(v).navigate(action);
    }



}

 */