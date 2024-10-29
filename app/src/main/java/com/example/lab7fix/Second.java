package com.example.lab7fix;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lab7fix.R;

public class Second extends Fragment {



    private     TextView textView;
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


       // TextView textView = view.findViewById(R.id.textView);
     //   registerForContextMenu(textView);

        Button buttonAdd = view.findViewById(R.id.register_button1);
       textView = view.findViewById(R.id.textView2);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleAdd(view);
            }
        });

        return view;
    }
 void handleAdd(View v) {
     // TextView textView = v.findViewById(R.id.textView2);
     textView.setText("click");

 }
}
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