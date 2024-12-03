package com.example.lab10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Second extends Fragment {

    private RecyclerView recyclerView;
    private CommentAdapter adapter; // Changed adapter to CommentAdapter
    private List<Comment> comments = new ArrayList<>();
    private TextView errorTextView;

    public Second() {}

    public static Second newInstance(String param1, String param2) {
        Second fragment = new Second();
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
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CommentAdapter(comments); // Changed to CommentAdapter
        recyclerView.setAdapter(adapter);

        errorTextView = view.findViewById(R.id.errorTextView);

        loadComments(); // Load comments directly

        return view;
    }

    private void loadComments() {
        NetworkService.getInstance()
                .getJSONApi()
                .getComments() // Fetch comments instead of posts
                .enqueue(new Callback<List<Comment>>() {
                    @Override
                    public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            comments.addAll(response.body());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Comment>> call, Throwable t) {
                        t.printStackTrace();
                        errorTextView.setVisibility(View.VISIBLE);
                    }
                });
    }
}
