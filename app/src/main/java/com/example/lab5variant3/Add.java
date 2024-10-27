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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText editTextName;
    private EditText editTextPhone;

    private  String name="";
    private String tel="";
    private String adres="";
    private String email="";
    private  String[] items;

    public Add() {
        // Required empty public constructor
    }


    public static Add newInstance(String param1, String param2) {
        Add fragment = new Add();
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
        // Inflate the layout for this fragment
     //   return inflater.inflate(R.layout.fragment_add, container, false);
        View view = inflater.inflate(R.layout.fragment_add, container, false);
      AddArgs args = AddArgs.fromBundle(getArguments());

        name = args.getName();
      email = args.getEmail();
      items = args.getSavedItem();
        editTextName = view.findViewById(R.id.editTextText3);
        editTextPhone = view.findViewById(R.id.editTextText4);
        Button button = view.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmit(view);
            }


        });
        return view;
    }


/*
    public void handleSubmit(View v) {
        String name = editTextName.getText().toString().trim();
        String email = editTextPhone.getText().toString().trim();

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

        // Создаем новый массив с дополнительным местом для строки name + email
        String[] updatedItems = new String[items.length + 1];
        System.arraycopy(items, 0, updatedItems, 0, items.length);

        // Добавляем строку name + email в конец нового массива
        updatedItems[items.length] = name + email;

        // Переход с обновленным массивом items
        AuthDirections.ActionAuthToPersonal action = AuthDirections.actionAuthToPersonal(name, email, updatedItems);
        Navigation.findNavController(v).navigate(action);
    }
*/


    public void handleSubmit(View v) {
        String name = editTextName.getText().toString().trim();
        String email = editTextPhone.getText().toString().trim();

        // Получаем ссылку на errorTextView через переданное представление
        TextView errorTextView = v.getRootView().findViewById(R.id.error);
        errorTextView.setVisibility(View.GONE);

        if (name.isEmpty() || email.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Пожалуйста, заполните все поля:\n");
            if (name.isEmpty()) errorMessage.append("Имя\n");
            if (email.isEmpty()) errorMessage.append("Почта\n");

            errorTextView.setText(errorMessage.toString());
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }

 /*       // Создаем новый массив с дополнительным местом для строки name + email
        String[] updatedItems = new String[items.length + 1];
        System.arraycopy(items, 0, updatedItems, 0, items.length);

        // Добавляем строку name + email в конец нового массива
        updatedItems[items.length] = name + email;

        // Переход с обновленным массивом items
        AuthDirections.ActionAuthToPersonal action = AuthDirections.actionAuthToPersonal(name, email, updatedItems);
        Navigation.findNavController(v).navigate(action);


  */
       AuthDirections.ActionAuthToPersonal action = AuthDirections.actionAuthToPersonal(name, email,new String[0]);
        //AuthDirections.ActionAuthToPersonal action = AuthDirections.actionAuthToPersonal(name, email,items);
        Navigation.findNavController(v).navigate(action);
    }

}


/*
    public void handleSubmit(View v) {
        String name = editTextName.getText().toString().trim();
        String email= editTextPhone.getText().toString().trim();

        TextView errorTextView = getView().findViewById(R.id.error);

        errorTextView.setVisibility(View.GONE);

        if (name.isEmpty() || email.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Пожалуйста, заполните все поля:\n");
            if (name.isEmpty()) errorMessage.append("Имя\n");
            if (email.isEmpty()) errorMessage.append("Почта\n");


            errorTextView.setText(errorMessage.toString());
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }
        items.push
        AddDirections.ActionAdd2ToPersonal action = AddDirections.actionAdd2ToPersonal(name, email, items);


        Navigation.findNavController(v).navigate(action);

    }
    */
