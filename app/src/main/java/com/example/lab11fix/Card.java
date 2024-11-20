
package com.example.lab11fix;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Card extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TS = "1";
    private static final String API_KEY = "23f31debdba1e947455a5b78a77e7e56";
    private static final String HASH = "5ef5fd12a0184b988b9f558f5a852eb6";

    private RecyclerView recyclerView;
    private MarvelItemAdapter adapter;
    private ProgressBar progressBar;
    private TextView textView;
    private int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new MarvelItemAdapter();
        recyclerView.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progressBar);
        textView = view.findViewById(R.id.textView);
        TextView showPopupButton = view.findViewById(R.id.showPopupButton);
        showPopupButton.setOnClickListener(this::showPopupMenu);


        if (getArguments() != null) {
            CardArgs args = CardArgs.fromBundle(getArguments());
            id = Integer.parseInt(args.getId());
            Toast.makeText(getContext(), "ID: " + id, Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchorView);
        popupMenu.inflate(R.menu.menu_toolbar);

        popupMenu.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            String type = null;

            if (itemId == R.id.characters) {
                type = "characters";
            } else if (itemId == R.id.series) {
                type = "series";
            } else if (itemId == R.id.comics) {
                type = "comics";
            } else if (itemId == R.id.creators) {
                type = "creators";
            } else if (itemId == R.id.stories) {
                type = "stories";
            } else {
                return false;
            }

            Toast.makeText(getContext(), "Loading: " + type, Toast.LENGTH_SHORT).show();
            Log.d("PopupMenu", "Selected type: " + type);
            loadData(type);
            return true;
        });

        popupMenu.show();
    }


    /*
    private void loadData(String type) {
        textView.setVisibility(View.GONE);
        Log.d("API Response", "START");
        Log.d("loadData", "Type: " + type + ", ID: " + id);
        progressBar.setVisibility(View.VISIBLE);

        MarvelApi marvelApi = NetworkService.getInstance().getMarvelApi();
        Call<MarvelResponse<MarvelItem>> call;
        Call<MarvelResponse<Character>> picture;


        switch (type) {
            case "characters":
                call = marvelApi.getEventCharacters(id, TS, API_KEY, HASH);
             //   picture = marvelApi.getCharacterByResourceUri( TS, API_KEY, HASH);
                break;
            case "comics":
                call = marvelApi.getEventComics(id, TS, API_KEY, HASH);

                break;
            case "creators":
                call = marvelApi.getEventCreators(id, TS, API_KEY, HASH);
                break;
            case "series":
                call = marvelApi.getEventSeries(id, TS, API_KEY, HASH);
                break;
            case "stories":
                call = marvelApi.getEventStories(id, TS, API_KEY, HASH);
                break;
            default:
                Toast.makeText(getContext(), "Unknown type: " + type, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                return;
        }



        call.enqueue(new Callback<MarvelResponse<MarvelItem>>() {
            @Override
            public void onResponse(Call<MarvelResponse<MarvelItem>> call, Response<MarvelResponse<MarvelItem>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    List<MarvelItem> items = response.body().getData().getResults();
                    if (items.isEmpty()) {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("No data available.");
                    } else {
                        adapter.setMarvelItems(items);
                    }
                } else {
                    Toast.makeText(getContext(), "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MarvelResponse<MarvelItem>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
*/


    private void loadData(String type) {
        textView.setVisibility(View.GONE);
        Log.d("API Response", "START");
        Log.d("loadData", "Type: " + type + ", ID: " + id);
        progressBar.setVisibility(View.VISIBLE);

        MarvelApi marvelApi = NetworkService.getInstance().getMarvelApi();
        Call<MarvelResponse<MarvelItem>> call;

        switch (type) {
            case "characters":
                call = marvelApi.getEventCharacters(id, TS, API_KEY, HASH);
                break;
            case "comics":
                call = marvelApi.getEventComics(id, TS, API_KEY, HASH);
                break;
            case "creators":
                call = marvelApi.getEventCreators(id, TS, API_KEY, HASH);
                break;
            case "series":
                call = marvelApi.getEventSeries(id, TS, API_KEY, HASH);
                break;
            case "stories":
                call = marvelApi.getEventStories(id, TS, API_KEY, HASH);
                break;
            default:
                Toast.makeText(getContext(), "Unknown type: " + type, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                return;
        }

        call.enqueue(new Callback<MarvelResponse<MarvelItem>>() {
            @Override
            public void onResponse(Call<MarvelResponse<MarvelItem>> call, Response<MarvelResponse<MarvelItem>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    List<MarvelItem> items = response.body().getData().getResults();
                    if (items.isEmpty()) {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("No data available.");
                    } else {

                        for (MarvelItem item : items) {

                            item.setImagePath(item.getThumbnail().getPath());
                            item.setImageExtension(item.getThumbnail().getExtension());
                        }
                        adapter.setMarvelItems(items);
                    }
                } else {
                    Toast.makeText(getContext(), "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MarvelResponse<MarvelItem>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}