package com.example.lab7fix;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Third extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static final String PREFS_FILE = "screenData";

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private RadioGroup genderGroup;
    private FloatingActionButton floatingActionButton;
    public Third() {

    }



    public static Third newInstance(String param1, String param2) {
        Third fragment = new Third();
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


        View view = inflater.inflate(R.layout.fragment_third, container, false);



        TextView haveAccount = view.findViewById(R.id.textView7);

        Button signInButton = view.findViewById(R.id.login_button);



        emailEditText = view.findViewById(R.id.emailET);
        passwordEditText = view.findViewById(R.id.passwordET);


        floatingActionButton = view.findViewById(R.id.fab);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            floatingActionButton.setTooltipText("send");
        }



       signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm(view);
            }
        });


        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRedirectToAuthorithation(view);
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDisplayModal(view);
            }
        });



        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;

    }


    private void validateForm(View view) {


        Log.d("Debug", "emailEditText: " + emailEditText);
        Log.d("Debug", "passwordEditText: " + passwordEditText);


        if ( emailEditText == null || passwordEditText == null ) {
            Log.e("Debug", "EditText или RadioGroup равны null");
            return;
        }


        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();



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

checkUser(view, email, password);
    }
    private void checkUser(View view,  String email, String password) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_FILE, AppCompatActivity.MODE_PRIVATE);


        String existingEmail = sharedPreferences.getString("email", null);
        String existingPassword = sharedPreferences.getString("password", null);
        if (existingEmail != null && existingEmail.equals(email) && existingPassword!=null && existingPassword.equals(password) ) {
            handleRedirect(view);

        }  else  {
            Toast.makeText(getActivity(), "Пожалуйста проверьте введенный пароль и почту", Toast.LENGTH_SHORT).show();
        }



    }

    void handleRedirect(View v) {
        Navigation.findNavController(v).navigate(R.id.action_third_to_second);
    }

    void handleRedirectToAuthorithation(View v) {
        Navigation.findNavController(v).navigate(R.id.action_third_to_first);
    }
    void handleDisplayModal(View v) {
        if (getActivity() != null) {
                new StartGameDialogFragment().show(getActivity().getSupportFragmentManager(), "GAME_DIALOG");
              }
    }



    public static  class StartGameDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.dialog_start_game)
                    .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            return builder.create();
        }
    }
}