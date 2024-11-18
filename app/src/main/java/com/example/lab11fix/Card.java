package com.example.lab11fix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Card extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private final String ts = "1";
    private final String apiKey = "23f31debdba1e947455a5b78a77e7e56";
    private final String hash = "5ef5fd12a0184b988b9f558f5a852eb6";

    private String mParam1;
    private String mParam2;
private String id;
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

     id = args.getId();


        return inflater.inflate(R.layout.fragment_card, container, false);
    }


    private void loadEvents(int page) {
   /*     isLoading = true;
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

    */
    }
}