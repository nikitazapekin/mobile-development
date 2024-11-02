package com.example.lab9;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.arch.core.util.Function;

import kotlin.jvm.functions.Function1;

public class DataController {

    private static DataController instance;
    private final MutableLiveData<String> liveData = new MutableLiveData<>();

    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }

    public LiveData<String> getData() {
        return liveData;
    }

    // Method to update data
    public void setData(String value) {
        liveData.setValue(value);
    }

    public LiveData<Integer> getLiveDataInt() {
        return Transformations.map(liveData, new Function1<String, Integer>() {
            @Override
            public Integer invoke(String input) {
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    return 0; // Default value in case of parsing error
                }
            }
        });
    }


}
