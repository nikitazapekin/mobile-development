package com.example.lab11fix;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.lab11fix.R;
import com.google.android.material.appbar.MaterialToolbar;

public class Third extends Fragment {

    public Third() {
        super(R.layout.fragment_third);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Инициализация Toolbar
        MaterialToolbar toolbar = view.findViewById(R.id.toolbarSecond);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        // Инициализация кнопки для показа PopupMenu
        TextView showPopupButton = view.findViewById(R.id.showPopupButton);
        showPopupButton.setOnClickListener(v -> showPopupMenu(v));
    }

    private void showPopupMenu(View anchorView) {
        // Создаем PopupMenu
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchorView);
        popupMenu.inflate(R.menu.menu_toolbar); // Подключаем меню

        // Обработка кликов на элементы меню
        popupMenu.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.first) {
                Toast.makeText(getContext(), "Опция 1 выбрана", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.first1) {
                Toast.makeText(getContext(), "Опция 2 выбрана", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.first2) {
                Toast.makeText(getContext(), "Опция 3 выбрана", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        // Показываем меню
        popupMenu.show();
    }
}

/*
package com.example.lab11fix;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.appbar.MaterialToolbar;
import android.widget.TextView;
import com.example.lab11fix.R;

public class Third extends Fragment {

    public Third() {
        super(R.layout.fragment_third);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_third, container, false);

        MaterialToolbar toolbar = view.findViewById(R.id.toolbarSecond);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        // Регистрируем контекстное меню для Toolbar
        registerForContextMenu(toolbar);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Создаем контекстное меню для TextView
        getActivity().getMenuInflater().inflate(R.menu.menu_toolbar, menu);
    }

    // Обрабатываем выбор элемента в контекстном меню
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.first) {
            Toast.makeText(getContext(), "Option 1 selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }


}
*/
/*
package com.example.lab11fix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.appbar.MaterialToolbar;

public class Third extends Fragment {

    public Third() {
        super(R.layout.fragment_third);
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_third, container, false);




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


}

*/