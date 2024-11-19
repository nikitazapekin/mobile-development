package com.example.lab11fix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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
private ProgressBar progressBar;
    public  ListOfEvents() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_events, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
     //  adapter = new EventAdapter(events);
        adapter = new EventAdapter(events, event -> {
         //   ListOfEventsDirections.ActionListOfEventsToCard action = ListOfEventsDirections.actionListOfEventsToCard("1");
          ListOfEventsDirections.ActionListOfEventsToCard action = ListOfEventsDirections.actionListOfEventsToCard(String.valueOf(event.getId()));
            Navigation.findNavController(view).navigate(action);
        });
        recyclerView.setAdapter(adapter);

        prevButton = view.findViewById(R.id.prevButton);
        nextButton = view.findViewById(R.id.nextButton);
        pageNumber = view.findViewById(R.id.pageNumber);
        errorTextView = view.findViewById(R.id.errorTextView);
        progressBar = view.findViewById(R.id.progressBar);
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
        progressBar.setVisibility(View.VISIBLE); // Показать ProgressBar
        errorTextView.setVisibility(View.GONE);
        pageNumber.setText("Page " + (page + 1));
        events.clear();
        NetworkService.getInstance()
                .getMarvelApi()
                .getEvents(limit, page * limit, ts, apiKey, hash)
                .enqueue(new Callback<MarvelResponse<Event>>() {
                    @Override
                    public void onResponse(Call<MarvelResponse<Event>> call, Response<MarvelResponse<Event>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            progressBar.setVisibility(View.GONE); // Скрыть ProgressBar
                            events.addAll(response.body().getData().getResults());
                            adapter.notifyDataSetChanged();
                        }
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<MarvelResponse<Event>> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        t.printStackTrace();
                        isLoading = false;
                        errorTextView.setVisibility(View.VISIBLE);
                    }
                });
    }



    /*
    private void loadEvents(int page) {
        isLoading = true;
        progressBar.setVisibility(View.VISIBLE); // Показать ProgressBar
        errorTextView.setVisibility(View.GONE); // Скрыть ошибку
        pageNumber.setText("Page " + (page + 1));
        events.clear();

        NetworkService.getInstance()
                .getMarvelApi()
                .getEvents(limit, page * limit, ts, apiKey, hash)
                .enqueue(new Callback<MarvelResponse<Event>>() {
                    @Override
                    public void onResponse(Call<MarvelResponse<Event>> call, Response<MarvelResponse<Event>> response) {
                        progressBar.setVisibility(View.GONE); // Скрыть ProgressBar
                        if (response.isSuccessful() && response.body() != null) {
                            events.addAll(response.body().getData().getResults());
                            adapter.notifyDataSetChanged();
                        }
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<MarvelResponse<Event>> call, Throwable t) {
                        progressBar.setVisibility(View.GONE); // Скрыть ProgressBar
                        t.printStackTrace();
                        isLoading = false;
                        errorTextView.setVisibility(View.VISIBLE); // Показать ошибку
                    }
                });
    }
*/


    public void handleRedirect(View v) {
        ListOfEventsDirections.ActionListOfEventsToCard action =
                ListOfEventsDirections.actionListOfEventsToCard("1");
        Navigation.findNavController(v).navigate(action);
    }

}
