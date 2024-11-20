package com.example.lab11fix;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;

import java.io.InputStream;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;  // Make sure this import is added
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarvelItemAdapter extends RecyclerView.Adapter<MarvelItemAdapter.MarvelItemViewHolder> {

    private List<MarvelItem> marvelItems = new ArrayList<>();

    @NonNull
    @Override
    public MarvelItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marvel, parent, false);
        return new MarvelItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MarvelItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MarvelItem marvelItem = marvelItems.get(position);
        holder.nameTextView.setText(marvelItem.getName() + "|" + marvelItem.getImagePath() + "." + marvelItem.getImageExtension());

        String imageUrl = marvelItem.getImagePath() + "." + marvelItem.getImageExtension();
        Log.d("url", imageUrl);



        Glide.with(holder.imageView.getContext())
              //  .load("https://i.annihil.us/u/prod/marvel/i/mg/b/b0/4ce59ea2103ac.jpg")

               .load(imageUrl)
             //   .timeout(10000)
                .into(holder.imageView);



/*
        MarvelApi marvelApi = NetworkService.getInstance().getMarvelApi();
        Call<ResponseBody> imageCall = marvelApi.getImage(imageUrl);

        imageCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {

                        InputStream inputStream = response.body().byteStream();
                        Bitmap bmp = BitmapFactory.decodeStream(inputStream);


                        if (holder.getAdapterPosition() == position) {
                            // Set the bitmap to ImageView
                            holder.imageView.setImageBitmap(bmp);
                        }
                    } catch (Exception e) {
                        Log.e("MarvelItemAdapter", "Error decoding image", e);
                    }
                } else {
                    Log.e("MarvelItemAdapter", "Failed to load image: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("MarvelItemAdapter", "Image request failed", t);
            }
        });

*/


    }

    @Override
    public int getItemCount() {
        return marvelItems.size();
    }

    public void setMarvelItems(List<MarvelItem> items) {
        this.marvelItems = items;
        notifyDataSetChanged();
    }

    class MarvelItemViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView resourseTextView;
        ImageView imageView;

        public MarvelItemViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            resourseTextView = itemView.findViewById(R.id.resourceUriTextView);
            imageView = itemView.findViewById(R.id.thumbnailImageView);
        }
    }
}

