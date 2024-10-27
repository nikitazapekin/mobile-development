package com.example.lab5variant3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Personal extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  String name="";
    private String tel="";
    private String adres="";
    private String email="";
    private  String[] items;
    public Personal() {
        // Required empty public constructor
    }


    public static Personal newInstance(String param1, String param2) {
        Personal fragment = new Personal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container, false);

        PersonalArgs args = PersonalArgs.fromBundle(getArguments());
        //  MakeOrderArgs argsOrder = MakeOrderArgs.fromBundle(getArguments());

        name = args.getName();
      email = args.getEmail();
items = args.getSavedItem();

     //   Toast.makeText(getContext(), "Выбранные элементы: " + Arrays.toString(items), Toast.LENGTH_SHORT).show();
        TextView textView1 = view.findViewById(R.id.textView8);
        TextView textView2 = view.findViewById(R.id.textView9);

        textView1.setText(name);
        textView2.setText(email);


        Button button = view.findViewById(R.id.buttonInsideDashedView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             useNavigate(view);
            }


        });

        return view;
    }

    public void useNavigate(View v) {
//
        PersonalDirections.ActionPersonalToAdd2 action = PersonalDirections.actionPersonalToAdd2(name, email, items.length > 1 ? items : new String[0]);
        Navigation.findNavController(v).navigate(action);

        //    PersonalDirections.ActionPersonalToAdd2 action = PersonalDirections.actionPersonalToAdd2(   name ,email, items.length> 1 ? items :  new String[0]  );
//      PersonalDirections.ActionSecondToMakeOrder action = PersonalDirections.actionSecondToMakeOrder(   name ,  tel,adres, items.length> 1 ? items :  new String[0]  );
    //    Navigation.findNavController(v).navigate(R.id.action_personal_to_add2);
  //      Navigation.findNavController(v).navigate(action);
    }
}

/*


package com.example.lab5variant3;

public class Participant {

    private String name;
    private String email;
    public Participant(  String name,String email) {

        this.name = name;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}


 */