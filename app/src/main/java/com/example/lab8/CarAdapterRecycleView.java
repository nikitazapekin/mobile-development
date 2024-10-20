

package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarAdapterRecycleView extends RecyclerView.Adapter<CarAdapterRecycleView.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Car> cars;

    CarAdapterRecycleView(Context context, List<Car> cars) {
        this.cars = cars;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Car car = cars.get(position);
       holder.nameView.setText(car.getName());
        holder.priceView.setText(String.valueOf(car.getPrice()));
          holder.descriptionView.setText(car.getDescribtion());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, priceView, descriptionView;

        ViewHolder(View view) {
            super(view);

            nameView = view.findViewById(R.id.name_text_view1);
           priceView = view.findViewById(R.id.price_text_view1);
            descriptionView = view.findViewById(R.id.describtion_text_view1);
        }
    }
}