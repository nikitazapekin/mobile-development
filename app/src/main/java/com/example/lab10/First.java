package com.example.lab10;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class First extends Fragment {

    private TextView todoTitle, todoStatus, userId, todoId;

    // Empty constructor
    public First() {}

    public static First newInstance(String param1, String param2) {
        First fragment = new First();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Initialize UI components
        todoTitle = view.findViewById(R.id.todoTitle);
        todoStatus = view.findViewById(R.id.todoStatus);
        userId = view.findViewById(R.id.userId);
        todoId = view.findViewById(R.id.todoId);

        // Fetch data from API
        fetchTodoData();

        return view;
    }

    private void fetchTodoData() {
        NetworkService networkService = NetworkService.getInstance();
        JSONPlaceholderApi api = networkService.getJSONApi();
        Call<Todo> call = api.getTodoWithID(125);

        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Todo todo = response.body();
                    todoTitle.setText(todo.getTitle());
                    todoStatus.setText(todo.isCompleted() ? "Status: Completed" : "Status: Not Completed");
                    userId.setText("User ID: " + todo.getUserId());
                    todoId.setText("TODO ID: " + todo.getId());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

/*
package com.example.lab10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class First extends Fragment {


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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}

*/