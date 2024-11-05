package com.example.lab9;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    String nameText;
private String  text;

    public String getNameText() {
        return nameText;
    }
    public  void setNameText(String name) {
        nameText= name;
    }


    String loadText() {
        return text;
    }
    void saveText(String s) {
        text =s;
    }

@Override
    protected  void onCleared() {

    }
}
