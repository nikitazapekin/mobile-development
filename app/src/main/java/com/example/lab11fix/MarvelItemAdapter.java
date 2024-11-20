
package com.example.lab11fix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

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
    public void onBindViewHolder(@NonNull MarvelItemViewHolder holder, int position) {
        MarvelItem marvelItem = marvelItems.get(position);
        holder.nameTextView.setText(marvelItem.getName()+"|"+ marvelItem.getImagePath() + "." + marvelItem.getImageExtension());




        String imageUrl = marvelItem.getImagePath() + "." + marvelItem.getImageExtension();
        Log.d("url", imageUrl);

        // Use Glide to load the image directly into the ImageView
      /*  Glide.with(holder.itemView.getContext())
                .load(imageUrl) // Load the image from the URL
                .into(holder.imageView); // Set the image into the ImageView

       */
        // Загружаем изображение через Retrofit
        /*    MarvelApi marvelApi = NetworkService.getInstance().getMarvelApi();
        Call<MarvelItem> imageCall = marvelApi.getImage(imageUrl);

        imageCall.enqueue(new Callback<MarvelItem>() {

                              @Override
                              public void onResponse(Call<MarvelItem> call, Response<MarvelItem> response) {
                                  if (response.isSuccessful() && response.body() != null) {

                                      Bitmap bmp = BitmapFactory.decodeStream(response.body().byteStream());

                                      holder.imageView.setImageBitmap(bmp);
                                  } else {


                                  }
                              }

                              @Override
                              public void onFailure(Call<MarvelItem> call, Throwable t) {

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
        TextView   resourseTextView;
        ImageView imageView;

        public MarvelItemViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            resourseTextView = itemView.findViewById(R.id.resourceUriTextView);
            imageView = itemView.findViewById(R.id.thumbnailImageView);
   //
        }
    }
}


