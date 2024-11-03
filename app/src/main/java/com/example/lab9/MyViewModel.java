package com.example.lab9;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    String nameText;


    public String getNameText() {
        return nameText;
    }
    public  void setNameText(String name) {
        nameText= name;
    }
}
