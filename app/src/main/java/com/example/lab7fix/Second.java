package com.example.lab7fix;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
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
        setHasOptionsMenu(true);
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


      /*  AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Действие при нажатии "Start"
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show(); */

        if (getActivity() != null) {
            new StartGameDialogFragment().show(getActivity().getSupportFragmentManager(), "GAME_DIALOG");
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



    public static  class StartGameDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.dialog_start_game)
                    .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Действие при нажатии "Start"
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Действие при нажатии "Cancel"
                        }
                    });
            return builder.create();
        }
    }
}
