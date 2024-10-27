package com.example.lab5variant3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Auth extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextAddress;


    public Auth() {
        // Required empty public constructor
    }


    public static Auth newInstance(String param1, String param2) {
        Auth fragment = new Auth();
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
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth, container, false);
    }
*/
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_auth, container, false);


    editTextName = view.findViewById(R.id.editTextText);
    editTextPhone = view.findViewById(R.id.editTextText2);
//    editTextAddress = view.findViewById(R.id.editTextText3);

    Button button = view.findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            handleSubmit(view);
        }


    });

    return view;
}


    public void handleSubmit(View v) {
        String name = editTextName.getText().toString().trim();
        String email= editTextPhone.getText().toString().trim();

        TextView errorTextView = getView().findViewById(R.id.textView7);

        errorTextView.setVisibility(View.GONE);

        if (name.isEmpty() || email.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Пожалуйста, заполните все поля:\n");
            if (name.isEmpty()) errorMessage.append("Имя\n");
            if (email.isEmpty()) errorMessage.append("Почта\n");


            errorTextView.setText(errorMessage.toString());
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }
        AuthDirections.ActionAuthToPersonal action = AuthDirections.actionAuthToPersonal(name, email, new String[0]);


        Navigation.findNavController(v).navigate(action);

    }


}