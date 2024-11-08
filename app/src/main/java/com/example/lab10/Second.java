package com.example.lab10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private PostAdapter adapter;
    private List<Post> posts = new ArrayList<>();
    private int currentPage = 1;
    private final int limit = 10;
    private boolean isLoading = false;
    private Button prevButton, nextButton;
    private TextView pageNumber;

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
        adapter = new PostAdapter(posts);
        recyclerView.setAdapter(adapter);

        prevButton = view.findViewById(R.id.prevButton);
        nextButton = view.findViewById(R.id.nextButton);
        pageNumber = view.findViewById(R.id.pageNumber);


        loadPosts(currentPage);

        prevButton.setOnClickListener(v -> {
            if (currentPage > 1) {
                currentPage--;
                loadPosts(currentPage);
            }
        });

        nextButton.setOnClickListener(v -> {
            currentPage++;
            loadPosts(currentPage);
        });

        return view;
    }

    private void loadPosts(int page) {
        isLoading = true;
        pageNumber.setText("Page " + page);
        posts.clear(); // Clear the list for new data

        NetworkService.getInstance()
                .getJSONApi()
                .getPosts(page, limit)
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            posts.addAll(response.body());
                            adapter.notifyDataSetChanged();
                        }
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        t.printStackTrace();
                        isLoading = false;
                    }
                });
    }
}

/*
package com.example.lab10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private PostAdapter adapter;
    private List<Post> posts = new ArrayList<>();
    private int currentPage = 1;
    private final int limit = 10;
    private boolean isLoading = false;

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
        adapter = new PostAdapter(posts);
        recyclerView.setAdapter(adapter);

        loadPosts(currentPage);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading && layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == posts.size() - 1) {
                    // Load next page
                    currentPage++;
                    loadPosts(currentPage);
                }
            }
        });

        return view;
    }

    private void loadPosts(int page) {
        isLoading = true;
        NetworkService.getInstance()
                .getJSONApi()
                .getPosts(page, limit)
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            posts.addAll(response.body());
                            adapter.notifyDataSetChanged();
                        }
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        t.printStackTrace();
                        isLoading = false;
                    }
                });
    }
}
 */