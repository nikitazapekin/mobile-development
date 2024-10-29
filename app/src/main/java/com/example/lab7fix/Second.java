package com.example.lab7fix;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lab7fix.R;
import com.google.android.material.appbar.MaterialToolbar;

public class Second extends Fragment {

    private TextView textView;
    private EditText editText;

    public Second() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Indicate that this fragment has its own menu
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button buttonAdd = view.findViewById(R.id.register_button1);
        Button buttonReverse = view.findViewById(R.id.register_button);
        textView = view.findViewById(R.id.textView2);
        editText = view.findViewById(R.id.nameET);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleAdd(view);
            }
        });

        buttonReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleReverse(view);
            }
        });

        MaterialToolbar toolbar = view.findViewById(R.id.toolbarSecond);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
        }

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    void handleAdd(View v) {
        String text = editText.getText().toString().trim();
        textView.setText(text);
    }

    void handleReverse(View v) {
        String text = textView.getText().toString().trim();
        if (!text.isEmpty()) {
            String[] words = text.split(" ");
            StringBuilder reversedText = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                reversedText.append(words[i]);
                if (i != 0) {
                    reversedText.append(" ");
                }
            }

            textView.setText(reversedText.toString());
        }
    }
}


/*
package com.example.lab7fix;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lab7fix.R;
import com.google.android.material.appbar.MaterialToolbar;

public class Second extends Fragment {



    private     TextView textView;
    private EditText editText;
    public Second() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);



        Button buttonAdd = view.findViewById(R.id.register_button1);
        Button buttonReverse = view.findViewById(R.id.register_button);
       textView = view.findViewById(R.id.textView2);
       editText = view.findViewById(R.id.nameET);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleAdd(view);
            }
        });

        buttonReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleReverse(view);
            }
        });


        MaterialToolbar toolbar = view.findViewById(R.id.toolbarSecond);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
        }



        return view;
    }
 void handleAdd(View v) {
     String text =editText.getText().toString().trim();
     textView.setText(text);

 }


    void handleReverse(View v) {
        String text = textView.getText().toString().trim();
        if (!text.isEmpty()) {
            String[] words = text.split(" ");
            StringBuilder reversedText = new StringBuilder();


            for (int i = words.length - 1; i >= 0; i--) {
                reversedText.append(words[i]);
                if (i != 0) {
                    reversedText.append(" ");
                }
            }

            textView.setText(reversedText.toString());
        }
    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
*/
/*
    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.setHeaderTitle("Выберите действие");
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        TextView textView = requireView().findViewById(R.id.textView);
        switch (item.getItemId()) {

            //com.example.lab7fix
         //   case com.example.lab7Fix:
          //      textView.setTextColor(Color.BLUE);
          //      Toast.makeText(getContext(), "Вы выбрали редактирование", Toast.LENGTH_SHORT).show();
           //     return true;
            case R.id.menu_edit_default:
                textView.setTextColor(Color.BLACK);
                Toast.makeText(getContext(), "Вы выбрали сброс", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
*/