package com.example.lab11fix;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApodFragment extends Fragment {

    private ImageView mainImageView;
    private EditText countEditText;
    private Button fetchImageOfTheDayButton;
    private Button fetchRandomImagesButton;
    private RecyclerView recyclerView;
    private ApodAdapter adapter;
    private List<NasaImage> apodList = new ArrayList<>();

    private static final String API_KEY = "HiviqHw1KxtCr3T8at33eJYOwJktuxAucFYTYzBe";

    private String currentImageOfTheDayUrl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apod, container, false);

        mainImageView = view.findViewById(R.id.mainImageView);
        countEditText = view.findViewById(R.id.countEditText);
        fetchImageOfTheDayButton = view.findViewById(R.id.fetchButtonOfDay);
        fetchRandomImagesButton = view.findViewById(R.id.fetchButton);
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ApodAdapter(getContext(), apodList);
        recyclerView.setAdapter(adapter);

        fetchImageOfTheDayButton.setOnClickListener(v -> fetchImageOfTheDay());
        fetchRandomImagesButton.setOnClickListener(v -> {
            String countStr = countEditText.getText().toString();
            if (TextUtils.isEmpty(countStr)) {
                Toast.makeText(getContext(), "Enter a valid count!", Toast.LENGTH_SHORT).show();
                return;
            }

            int count = Integer.parseInt(countStr);
            fetchRandomImages(count);
        });

        fetchImageOfTheDay();
        return view;
    }

    private void fetchImageOfTheDay() {
        NetworkService.getInstance().getNasaApi().getImageOfTheDay(API_KEY)
                .enqueue(new Callback<NasaImage>() {
                    @Override
                    public void onResponse(Call<NasaImage> call, Response<NasaImage> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            NasaImage imageOfTheDay = response.body();
                            currentImageOfTheDayUrl = imageOfTheDay.getUrl();
                            Glide.with(requireContext()).load(currentImageOfTheDayUrl).into(mainImageView);
                        } else {
                            Toast.makeText(getContext(), "Failed to load Image of the Day!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<NasaImage> call, Throwable t) {
                        Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void fetchRandomImages(int count) {
        NetworkService.getInstance().getNasaApi().getRandomImages(count, API_KEY)
                .enqueue(new Callback<List<NasaImage>>() {
                    @Override
                    public void onResponse(Call<List<NasaImage>> call, Response<List<NasaImage>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            apodList.clear();
                            apodList.addAll(response.body());
                            adapter.notifyDataSetChanged();

                            if (!apodList.isEmpty()) {
                                NasaImage pictureOfDay = apodList.get(0);
                                Glide.with(requireContext()).load(pictureOfDay.getUrl()).into(mainImageView);
                            }
                        } else {
                            Toast.makeText(getContext(), "Failed to fetch images!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<NasaImage>> call, Throwable t) {
                        Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
