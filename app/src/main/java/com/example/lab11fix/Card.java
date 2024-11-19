
package com.example.lab11fix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.lab11fix.R;

import java.util.ArrayList;
import java.util.List;

public class Card extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private final String ts = "1";
    private final String apiKey = "23f31debdba1e947455a5b78a77e7e56";
    private final String hash = "5ef5fd12a0184b988b9f558f5a852eb6";
    private RecyclerView recyclerView;
    private MarvelItemAdapter adapter;
    private int id;

    private boolean isLoading = false;

    private ProgressBar progressBar;

    private Button btnCharacters, btnStories, btnCreators, btnComics, btnSeries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MarvelItemAdapter();
        recyclerView.setAdapter(adapter);

        btnCharacters = view.findViewById(R.id.btnCharacters);
        btnStories = view.findViewById(R.id.btnStories);
        btnCreators = view.findViewById(R.id.btnCreators);
        btnComics = view.findViewById(R.id.btnComics);
        btnSeries = view.findViewById(R.id.btnSeries);
        progressBar = view.findViewById(R.id.progressBar);
        btnCharacters.setOnClickListener(v -> loadData("characters"));
        btnStories.setOnClickListener(v -> loadData("stories"));
        btnCreators.setOnClickListener(v -> loadData("creators"));
        btnComics.setOnClickListener(v -> loadData("comics"));
        btnSeries.setOnClickListener(v -> loadData("series"));

        CardArgs args =CardArgs.fromBundle(getArguments());



        id = Integer.parseInt(args.getId());
        Toast.makeText(getContext(), "ID: " + id, Toast.LENGTH_SHORT).show();
        return view;
    }

    private void loadData(String type) {

        progressBar.setVisibility(View.VISIBLE);
        MarvelApi marvelApi = NetworkService.getInstance().getMarvelApi();

        Call<MarvelResponse<Event>> call = marvelApi.getEventById(id, ts, apiKey, hash);

        call.enqueue(new Callback<MarvelResponse<Event>>() {
            @Override
            public void onResponse(Call<MarvelResponse<Event>> call, Response<MarvelResponse<Event>> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    MarvelResponse<Event> marvelResponse = response.body();
                    if (marvelResponse != null && marvelResponse.getData() != null) {
                        Event event = marvelResponse.getData().getResults().get(0);
                        List<MarvelItem> items = new ArrayList<>();


                        switch (type) {
                            case "characters":
                                for (Event.Characters.CharacterItem character : event.getCharacters().getItems()) {
                                    items.add(new MarvelItem(character.getName(), character.getResourceURI()));
                                }
                                break;
                            case "stories":
                                for (Event.Stories.StoryItem story : event.getStories().getItems()) {
                                    items.add(new MarvelItem(story.getName(), story.getResourceURI()));
                                }
                                break;
                            case "creators":
                                for (Event.Creators.CreatorItem creator : event.getCreators().getItems()) {
                                    items.add(new MarvelItem(creator.getName(), creator.getResourceURI()));
                                }
                                break;
                            case "comics":
                                for (Event.Comics.ComicItem comic : event.getComics().getItems()) {
                                    items.add(new MarvelItem(comic.getName(), comic.getResourceURI()));
                                }
                                break;
                            case "series":
                                for (Event.Series.SeriesItem series : event.getSeries().getItems()) {
                                    items.add(new MarvelItem(series.getName(), series.getResourceURI()));
                                }
                                break;
                        }

                        adapter.setMarvelItems(items);
                    }
                } else {
                    Toast.makeText(getContext(), "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MarvelResponse<Event>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/*
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.lab11fix.R;
public class Card extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private final String ts = "1";
    private final String apiKey = "23f31debdba1e947455a5b78a77e7e56";
    private final String hash = "5ef5fd12a0184b988b9f558f5a852eb6";

    private String mParam1;
    private String mParam2;
private int id;
    public Card() {
        // Required empty public constructor
    }


    public static Card newInstance(String param1, String param2) {
        Card fragment = new Card();
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

       CardArgs args =CardArgs.fromBundle(getArguments());
        //  MakeOrderArgs argsOrder = MakeOrderArgs.fromBundle(getArguments());

  //   id = args.getId();
        id = Integer.parseInt(args.getId());

        Toast.makeText(getContext(), "ID: " + id, Toast.LENGTH_SHORT).show();
loadEvent();
        //    return inflater.inflate(R.layout.fragment_card, container, false);
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        setHasOptionsMenu(true); // Enable menu for this fragment

        // Your existing code here...


        View showMenuButton = view.findViewById(R.id.showMenuButton);
        showMenuButton.setOnLongClickListener(v -> {
            requireActivity().openContextMenu(v);
            return true;
        });


        return view;
    }


    private void loadEvent() {
        MarvelApi marvelApi = NetworkService.getInstance().getMarvelApi();


        Call<MarvelResponse<Event>> call = marvelApi.getEventById(

              id,   ts, apiKey, hash
        );


        call.enqueue(new Callback<MarvelResponse<Event>>() {
            @Override
            public void onResponse(Call<MarvelResponse<Event>> call, Response<MarvelResponse<Event>> response) {
                if (response.isSuccessful()) {

                    MarvelResponse<Event> marvelResponse = response.body();
                    if (marvelResponse != null && marvelResponse.getData() != null) {
                        Event event = marvelResponse.getData().getResults().get(0);

                        Toast.makeText(getContext(), "Event: " + event.getTitle(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Failed to load event", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MarvelResponse<Event>> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





}
*/