package com.example.lab7fix;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.SharedPreferences;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class First extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private static final String TAG = "MainActivity";
    private static final String USER_KEY = "userData";
    public static final String PREFS_FILE = "screenData";
    private static final String CHANNEL_ID = "registration_channel";
    private static final int NOTIFICATION_ID = 1;

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private RadioGroup genderGroup;

    private FloatingActionButton floatingActionButton;

    public First() {

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

        Button registerButton = view.findViewById(R.id.register_button);


        nameEditText = view.findViewById(R.id.nameET);
        emailEditText = view.findViewById(R.id.nameET1);
        passwordEditText = view.findViewById(R.id.nameET2);
        genderGroup = view.findViewById(R.id.pizza_group);


        floatingActionButton = view.findViewById(R.id.fab);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            floatingActionButton.setTooltipText("send");
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
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
                handleDisplayInfo(view);
            }
        });


        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    private void validateForm(View view) {


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
        saveUser(view, name, email, password, selectedGenderId);
        showNotification();
    }

    private void saveUser(View view, String name, String email, String password, int genderId) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_FILE, AppCompatActivity.MODE_PRIVATE);


        String existingEmail = sharedPreferences.getString("email", null);
        if (existingEmail != null && existingEmail.equals(email)) {
            Toast.makeText(getActivity(), "Пользователь с таким email уже существует", Toast.LENGTH_SHORT).show();
            return;
        }


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putInt("genderId", genderId);
        editor.apply();
        handleRedirect(view);
        Toast.makeText(getActivity(), "Данные пользователя сохранены", Toast.LENGTH_SHORT).show();
    }


    void handleRedirect(View v) {
        Navigation.findNavController(v).navigate(R.id.action_first_to_second);
    }

    void handleRedirectToAuthorithation(View v) {
        Navigation.findNavController(v).navigate(R.id.action_first_to_third);
    }

    void handleDisplayInfo(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void showNotification() {
        // Создание канала уведомлений, если версия Android >= Oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Registration Channel";
            String description = "Notifications for successful registration";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        // Создание самого уведомления
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                      .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Регистрация успешна")
                .setContentText("Ваши данные успешно сохранены.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}

