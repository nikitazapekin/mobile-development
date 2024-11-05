package com.example.lab9;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> selected =
            new MutableLiveData<String>();

    public void select(String item) {

        selected.setValue(item);
    }



}
