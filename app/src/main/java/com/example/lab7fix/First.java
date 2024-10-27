package com.example.lab7fix;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.appbar.MaterialToolbar;

public class First extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private RadioGroup genderGroup;


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

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        TextView haveAccount = view.findViewById(R.id.textView7);
        Button button = view.findViewById(R.id.button);
        Button registerButton = view.findViewById(R.id.register_button);

        // Get EditTexts and RadioGroup from the inflated view
        /*   EditText nameEditText = view.findViewById(R.id.nameET);
        EditText emailEditText = view.findViewById(R.id.nameET1);
        EditText passwordEditText = view.findViewById(R.id.nameET2);
        RadioGroup genderGroup = view.findViewById(R.id.pizza_group);
*/


        nameEditText = view.findViewById(R.id.nameET);
        emailEditText = view.findViewById(R.id.nameET1);
        passwordEditText = view.findViewById(R.id.nameET2);
        genderGroup = view.findViewById(R.id.pizza_group);

        // Проверка на null
        Log.d("Debug=================", "nameEditText: " + nameEditText);
        Log.d("Debug", "emailEditText: " + emailEditText);
        Log.d("Debug", "passwordEditText: " + passwordEditText);
        Log.d("Debug", "genderGroup: " + genderGroup);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm(view);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRedirect(view);
            }
        });

        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRedirectToAuthorithation(view);
            }
        });

        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    private void validateForm(View view) {
        // Use the view passed in to find the EditTexts and RadioGroup
    /*    EditText nameEditText = view.findViewById(R.id.nameET);
        EditText emailEditText = view.findViewById(R.id.nameET1);
        EditText passwordEditText = view.findViewById(R.id.nameET2);
        RadioGroup genderGroup = view.findViewById(R.id.pizza_group);
 */
        // Debugging logs
        Log.d("Debug", "nameEditText: " + nameEditText);
        Log.d("Debug", "emailEditText: " + emailEditText);
        Log.d("Debug", "passwordEditText: " + passwordEditText);
        Log.d("Debug", "genderGroup: " + genderGroup);

        if (nameEditText == null || emailEditText == null || passwordEditText == null || genderGroup == null) {
            Log.e("Debug", "EditText или RadioGroup равны null");
            return;
        }

        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();

        // Проверка на пустоту полей
        if (name.isEmpty()) {
            Toast.makeText(getActivity(), "Введите имя", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty()) {
            Toast.makeText(getActivity(), "Введите почту", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(getActivity(), "Введите пароль", Toast.LENGTH_SHORT).show();
            return;
        }


        if (password.length() < 6) {
            Toast.makeText(getActivity(), "Пароль должен содержать минимум 6 символов", Toast.LENGTH_SHORT).show();
            return;
        }


        if (selectedGenderId == -1) {
            Toast.makeText(getActivity(), "Выберите пол", Toast.LENGTH_SHORT).show();
            return;
        }

        handleRedirect(view);
    }

    void handleRedirect(View v) {
        Navigation.findNavController(v).navigate(R.id.action_first_to_second);
    }

    void handleRedirectToAuthorithation(View v) {
        Navigation.findNavController(v).navigate(R.id.action_first_to_third);
    }
}


/*
package com.example.lab7fix;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import android.widget.EditText;
import android.widget.Toast;
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


        View view = inflater.inflate(R.layout.fragment_first, container, false);

        TextView haveAccount = view.findViewById(R.id.textView7);
        Button button = view.findViewById(R.id.button);
        Button registerButton = view.findViewById(R.id.register_button);



        EditText nameEditText = view.findViewById(R.id.nameET);
        EditText emailEditText = view.findViewById(R.id.nameET1);
        EditText passwordEditText = view.findViewById(R.id.nameET2);
        RadioGroup genderGroup = view.findViewById(R.id.pizza_group);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm(view);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRedirect(view);
            }


        });
        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRedirectToAuthorithation(view);
            }
        });
        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
       ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;

    }




    private void validateForm(View view) {
        EditText nameEditText = view.findViewById(R.id.nameET);
        EditText emailEditText = view.findViewById(R.id.nameET1);
        EditText passwordEditText = view.findViewById(R.id.nameET2);
        RadioGroup genderGroup = view.findViewById(R.id.pizza_group);
        if (nameEditText == null || emailEditText == null || passwordEditText == null || genderGroup == null) {
         //   Log.e("Debug", "EditText или RadioGroup равны null");
            return;
        }

        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();

        // Проверка на пустоту полей
        if (name.isEmpty()) {
            Toast.makeText(getActivity(), "Введите имя", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty()) {
            Toast.makeText(getActivity(), "Введите почту", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(getActivity(), "Введите пароль", Toast.LENGTH_SHORT).show();
            return;
        }

        // Проверка длины пароля
        if (password.length() < 6) {
            Toast.makeText(getActivity(), "Пароль должен содержать минимум 6 символов", Toast.LENGTH_SHORT).show();
            return;
        }

        // Проверка выбора пола
        if (selectedGenderId == -1) {
            Toast.makeText(getActivity(), "Выберите пол", Toast.LENGTH_SHORT).show();
            return;
        }

    }
    void handleRedirect(View v) {


            Navigation.findNavController(v).navigate(R.id.action_first_to_second);


    }
    void handleRedirectToAuthorithation(View v) {
        Navigation.findNavController(v).navigate(R.id.action_first_to_third);
    }
}
*/
//  RecyclerFragmentDirections.ActionRecyclerFragmentToDetailFragment action =
//        RecyclerFragmentDirections.actionRecyclerFragmentToDetailFragment(name, fullDecribtion, describtion, price, imageResId);
//Navigation.findNavController(v).navigate(action);