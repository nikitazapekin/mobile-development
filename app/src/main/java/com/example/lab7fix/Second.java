
package com.example.lab7fix;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;


public class Second extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Second() {
        // Required empty public constructor
    }


    public static Second newInstance(String param1, String param2) {
        Second fragment = new Second();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    registerForContextMenu(findViewById(R.id.textView));
        //registerForContextMenu(() findViewById(R.layout.textView));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        registerForContextMenu(view.findViewById(R.id.textView));
return view;

    //    return inflater.inflate(R.layout.fragment_second, container, false);
    }
    /*

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Выберите режим");
        getMenuInflater().inflate(R.id.menu_edit, menu);
    }
public  boolean onContextItemSelected(MenuItem item) {

        TextView textv = (TextView) findViewById(R.id.textView);
        switch(item.getItemId()) {
            case R.id.menu_edit:
                textv.setTextColor(Color.BLUE);
            default:
                return super.onContextItemSelected(item);
        }
}
*/

}

