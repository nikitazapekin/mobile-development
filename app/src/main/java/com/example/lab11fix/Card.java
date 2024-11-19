
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

  private void loadData(String type) {
        textView.setVisibility(View.GONE);
        Log.d("API Response", "START");
        Log.d("loadData", "Type: " + type + ", ID: " + id);
        progressBar.setVisibility(View.VISIBLE);

        MarvelApi marvelApi = NetworkService.getInstance().getMarvelApi();
        Call<MarvelResponse<Event>> call = marvelApi.getEventById(id, TS, API_KEY, HASH);

        call.enqueue(new Callback<MarvelResponse<Event>>() {
            @Override
            public void onResponse(@NonNull Call<MarvelResponse<Event>> call, @NonNull Response<MarvelResponse<Event>> response) {
                progressBar.setVisibility(View.GONE);
                Log.d("API респ", response.toString());
                if (response.isSuccessful() && response.body() != null && response.body().getData() != null) {
                    Log.d("API Response", response.toString());

                    Event event = response.body().getData().getResults().get(0);
                    List<MarvelItem> items = parseItems(event, type);
                    adapter.setMarvelItems(items);
                } else {
                    Toast.makeText(getContext(), "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MarvelResponse<Event>> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d("API респ" , "ошибка");
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<MarvelItem> parseItems(Event event, String type) {
        List<MarvelItem> items = new ArrayList<>();

        if (type.equals("characters")) {
            for (Event.Characters.CharacterItem character : event.getCharacters().getItems()) {
                items.add(new MarvelItem(character.getName(), character.getResourceURI()));
                Log.d("parseItems", "Added character: " + character.getName());
            }
        } else if (type.equals("stories")) {
            for (Event.Stories.StoryItem story : event.getStories().getItems()) {
                items.add(new MarvelItem(story.getName(), story.getResourceURI()));
                Log.d("parseItems", "Added character: " + story.getName());
            }
        } else if (type.equals("creators")) {
            for (Event.Creators.CreatorItem creator : event.getCreators().getItems()) {
                items.add(new MarvelItem(creator.getName(), creator.getResourceURI()));
                Log.d("parseItems", "Added character: " + creator.getName());
            }
        } else if (type.equals("comics")) {
            for (Event.Comics.ComicItem comic : event.getComics().getItems()) {
                items.add(new MarvelItem(comic.getName(), comic.getResourceURI()));
                Log.d("parseItems", "Added character: " + comic.getName());
            }
        } else if (type.equals("series")) {
            for (Event.Series.SeriesItem series : event.getSeries().getItems()) {
                items.add(new MarvelItem(series.getName(), series.getResourceURI()));
                Log.d("parseItems", "Added character: " + series.getName());
            }
        }

        return items;
    }


}
