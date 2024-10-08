package com.example.navig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class Second extends Fragment {

    private static final String ARG_NAME = "name";
    private String mName;



    private  String name="";
    private String tel="";
    private String adres="";
    private  String[] items;
    public Second() {

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

        SecondArgs args = SecondArgs.fromBundle(getArguments());
        MakeOrderArgs argsOrder = MakeOrderArgs.fromBundle(getArguments());

        name = args.getName();
        tel = args.getTelephone();
        adres = args.getAdres();
        // items = args.getSavedItems();
       // items = args.getSavedItems();
        String[] items = args.getSavedItem();
        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

textView1.setText(name);
textView2.setText(tel);



        Button button = view.findViewById(R.id.buttonInsideDashedView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRedirect(view);
            }


        });




        return view;
    }






    public void handleRedirect(View v) {


   SecondDirections.ActionSecondToMakeOrder action = SecondDirections.actionSecondToMakeOrder(   name ,  tel,adres,  new String[0] );

   Navigation.findNavController(v).navigate(action);
    }

}