package com.example.lab11fix;

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

public class ListOfEvents extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private List<Event> events = new ArrayList<>();
    private int currentPage = 0;
    private final int limit = 20;
    private final String ts = "1";
    private final String apiKey = "23f31debdba1e947455a5b78a77e7e56";
    private final String hash = "5ef5fd12a0184b988b9f558f5a852eb6";
    private boolean isLoading = false;
    private Button prevButton, nextButton;
    private TextView pageNumber, errorTextView;

    public  ListOfEvents() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_events, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EventAdapter(events);
        recyclerView.setAdapter(adapter);

        prevButton = view.findViewById(R.id.prevButton);
        nextButton = view.findViewById(R.id.nextButton);
        pageNumber = view.findViewById(R.id.pageNumber);
        errorTextView = view.findViewById(R.id.errorTextView);

        loadEvents(currentPage);

        prevButton.setOnClickListener(v -> {
            if (currentPage > 0) {
                currentPage--;
                loadEvents(currentPage);
            }
        });

        nextButton.setOnClickListener(v -> {
            currentPage++;
            loadEvents(currentPage);
        });

        return view;
    }

    private void loadEvents(int page) {
        isLoading = true;
        pageNumber.setText("Page " + (page + 1));
        events.clear();
        NetworkService.getInstance()
                .getMarvelApi()
                .getEvents(limit, page * limit, ts, apiKey, hash)
                .enqueue(new Callback<MarvelResponse<Event>>() {
                    @Override
                    public void onResponse(Call<MarvelResponse<Event>> call, Response<MarvelResponse<Event>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            events.addAll(response.body().getData().getResults());
                            adapter.notifyDataSetChanged();
                        }
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<MarvelResponse<Event>> call, Throwable t) {
                        t.printStackTrace();
                        isLoading = false;
                        errorTextView.setVisibility(View.VISIBLE);
                    }
                });
    }
}

/*
package com.example.lab11fix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ListOfEvents extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_events, container, false);


        return view;
    }


}
*/

/*
package com.example.lab11fix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOfEvents extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String API_KEY = "23f31debdba1e947455a5b78a77e7e56";
    private static final String HASH = "5ef5fd12a0184b988b9f558f5a852eb6";
    private static final String TIMESTAMP = "1";


    private String mParam1;
    private String mParam2;

    public ListOfEvents() {
        // Required empty public constructor
    }


    public static ListOfEvents newInstance(String param1, String param2) {
        ListOfEvents fragment = new ListOfEvents();
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



        NetworkService networkService = NetworkService.getInstance();
        MarvelApi api = networkService.getMarvelApi();

        Call<MarvelResponse<Event>> call = api.getEvents(20, TIMESTAMP, API_KEY, HASH);

        call.enqueue(new Callback<MarvelResponse<Event>>() {
            @Override
            public void onResponse(Call<MarvelResponse<Event>> call, Response<MarvelResponse<Event>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (Event event : response.body().getData().getResults()) {
                     //   System.out.println("Event Title: " + event.getTitle());
                    }
                } else {
                //    System.out.println("Request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MarvelResponse<Event>> call, Throwable t) {
           //     System.err.println("Request failed: " + t.getMessage());
            }
        });
 //   }


        return inflater.inflate(R.layout.fragment_list_of_events, container, false);
    }
}
*/