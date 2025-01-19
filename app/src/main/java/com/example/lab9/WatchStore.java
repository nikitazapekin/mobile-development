package com.example.lab9;

import java.util.ArrayList;
import java.util.List;

public class WatchStore {

    public static List<Watch> getWatches() {
        List<Watch> watches = new ArrayList<>();
        if (watches.isEmpty()) {
            watches.add(new Watch("Rolex Submariner", "Luxury diving watch", 200, 3,"A luxurious diving watch known for its reliability and style.", R.drawable.car));
            watches.add(new Watch("Rolex Submariner", "Luxury diving watch", 200, 3,"A luxurious diving watch known for its reliability and style.", R.drawable.car));
            watches.add(new Watch("Rolex Submariner", "Luxury diving watch", 200, 3,"A luxurious diving watch known for its reliability and style.", R.drawable.car));
            watches.add(new Watch("Rolex Submariner", "Luxury diving watch", 200, 3,"A luxurious diving watch known for its reliability and style.", R.drawable.car));
            watches.add(new Watch("Rolex Submariner", "Luxury diving watch", 200, 3,"A luxurious diving watch known for its reliability and style.", R.drawable.car));
            watches.add(new Watch("Rolex Submariner", "Luxury diving watch", 200, 3,"A luxurious diving watch known for its reliability and style.", R.drawable.car));
            watches.add(new Watch("Rolex Submariner", "Luxury diving watch", 200, 3,"A luxurious diving watch known for its reliability and style.", R.drawable.car));

        }

        return watches;
    }
}

