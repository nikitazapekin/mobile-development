package com.example.navig;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.navig.MainDirections;

public class Main extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextAddress;

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


        editTextName = view.findViewById(R.id.editTextText);
        editTextPhone = view.findViewById(R.id.editTextText2);
        editTextAddress = view.findViewById(R.id.editTextText3);

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
        String phone = editTextPhone.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        TextView errorTextView = getView().findViewById(R.id.textView7);

        errorTextView.setVisibility(View.GONE);

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Пожалуйста, заполните все поля:\n");
            if (name.isEmpty()) errorMessage.append("- Имя\n");
            if (phone.isEmpty()) errorMessage.append("- Телефон\n");
            if (address.isEmpty()) errorMessage.append("- Адрес доставки\n");

            errorTextView.setText(errorMessage.toString());
            errorTextView.setVisibility(View.VISIBLE);
            return;
        }


        MainDirections.ActionMain2ToSecond action = MainDirections.actionMain2ToSecond(name, phone, address, new String[0]);
        Navigation.findNavController(v).navigate(action);
    }


    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
