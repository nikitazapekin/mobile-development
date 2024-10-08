package com.example.navig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.Arrays;

public class Second extends Fragment {

    private static final String ARG_NAME = "name";
    private String mName;


    private LinearLayout offersContainer;
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

        String[] items = args.getSavedItem();


        Toast.makeText(getContext(), "Выбранные элементы: " + Arrays.toString(items), Toast.LENGTH_SHORT).show();
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

        TextView itemsTextView = view.findViewById(R.id.textInsideDashedView1);


        if(items.length>1) {


        itemsTextView.setVisibility(View.GONE);

            LayoutInflater itemInflater = LayoutInflater.from(getContext());

            offersContainer = view.findViewById(R.id.elems);

for (String item : items ){
    View itemView = itemInflater.inflate(R.layout.list_item, offersContainer, false);
    TextView itemName = itemView.findViewById(R.id.itemName);
    itemName.setText(item);
    offersContainer.addView(itemView);
}


        } else {
            itemsTextView.setVisibility(View.VISIBLE);
        }



        return view;
    }






    public void handleRedirect(View v) {


   SecondDirections.ActionSecondToMakeOrder action = SecondDirections.actionSecondToMakeOrder(   name ,  tel,adres,  new String[0] );

   Navigation.findNavController(v).navigate(action);
    }

}