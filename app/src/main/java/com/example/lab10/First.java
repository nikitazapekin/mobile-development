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

    private TextView commentName, commentEmail, commentBody, errorTextView;
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

        commentName = view.findViewById(R.id.commentName);
        commentEmail = view.findViewById(R.id.commentEmail);
        commentBody = view.findViewById(R.id.commentBody);
        errorTextView = view.findViewById(R.id.errorTextView);
        progressBar = view.findViewById(R.id.progress);

        fetchCommentData();

        return view;
    }

    private void fetchCommentData() {
        NetworkService networkService = NetworkService.getInstance();
        JSONPlaceholderApi api = networkService.getJSONApi();
        Call<Comment> call = api.getCommentWithID(400);

        call.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Comment comment = response.body();
                    commentName.setText("Name: " + comment.getName());
                    commentEmail.setText("Email: " + comment.getEmail());
                    commentBody.setText("Comment: " + comment.getBody());
                }
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                errorTextView.setVisibility(View.VISIBLE);
                t.printStackTrace();
            }
        });
    }
}
