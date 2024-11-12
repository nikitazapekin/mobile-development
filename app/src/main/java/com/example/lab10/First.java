package com.example.lab10;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class First extends Fragment {

    private TextView todoTitle, todoStatus, userId, todoId, errorTextView;
private Boolean isFetching;
private ProgressBar progressBar;
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

        View view = inflater.inflate(R.layout.fragment_first, container, false);


        todoTitle = view.findViewById(R.id.todoTitle);
        todoStatus = view.findViewById(R.id.todoStatus);
        userId = view.findViewById(R.id.userId);
        todoId = view.findViewById(R.id.todoId);
errorTextView = view.findViewById(R.id.errorTextView);
progressBar = view.findViewById(R.id.progress);
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
                errorTextView.setVisibility(View.VISIBLE);
                t.printStackTrace();

            }
        });
    }
}
