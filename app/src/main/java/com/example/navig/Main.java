package com.example.navig;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.navig.MainDirections;


public class Main extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Main() {

    }


    public static Main newInstance(String param1, String param2) {
        Main fragment = new Main();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();

                String name = "Alex";


                MainDirections.ActionMain2ToSecond action = MainDirections.actionMain2ToSecond(name);

                //     MainDirections.ActionMain2ToSecond action = MainDirections.ActionMain2ToSecond(name);



               // MainDirections.ActionMain2ToSecond action = MainDirections.actionMain2ToSecond(name);
                Navigation.findNavController(view).navigate(action);
                //   Navigation.findNavController(view)
                 //      .navigate(action);


            }
        });

        return view;
    }

}

/*
com.example.navig.MainDirections.ActionMainToSecond action = com.example.navig.MainDirections.actionMainToSecond(name);
                Navigation.findNavController(view)
                        .navigate(action);
*/

/*


                MainDirections.ActionMain2ToSecond action =
                        MainDirections.actionMain2ToSecond(name);

                // Навигация с аргументом
                NavHostFragment.findNavController(Main.this).navigate(action);


                 */
//    MessageFragmentDirections.ActionMessageFragment
//    MainDirections.ActionMain2ToSecond action =
//            MainDirections.actionMain2ToSecond(name);






//    Navigation.findNavController(view)

//          .navigate(R.id.action_main2_to_second);



//    MainFragmentDirections.ActionMainToSecond action = Main