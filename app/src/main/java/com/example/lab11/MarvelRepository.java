package com.example.lab11;



import android.os.AsyncTask;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarvelRepository {

    private static final String PUBLIC_KEY = "23f31debdba1e947455a5b78a77e7e56";
    private static final String PRIVATE_KEY = "318e1a320fe977dca190d7f8a4031ab3755ec422";

    public void fetchMarvelEvents() {
        // Step 1: Generate `ts` and `hash`
        int ts = 1;  // Fixed value
        String stringToHash = ts + PRIVATE_KEY + PUBLIC_KEY;
        String hash = HashUtils.md5(stringToHash);

        // Step 2: Create the Retrofit call
        NetworkService networkService = NetworkService.getInstance();
        MarvelApi marvelApi = networkService.getMarvelApi();

        // Step 3: Execute the request asynchronously
        Call<MarvelResponse> call = marvelApi.getMarvelEvents(20, ts, PUBLIC_KEY, hash);

        call.enqueue(new Callback<MarvelResponse>() {
            @Override
            public void onResponse(Call<MarvelResponse> call, Response<MarvelResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("MarvelRepository", "Fetched data: " + response.body().getData().getEvents());
                } else {
                    Log.e("MarvelRepository", "Failed to fetch data");
                }
            }

            @Override
            public void onFailure(Call<MarvelResponse> call, Throwable t) {
                Log.e("MarvelRepository", "Error: " + t.getMessage());
            }
        });
    }
}
