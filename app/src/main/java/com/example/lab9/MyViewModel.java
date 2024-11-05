package com.example.lab9;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    String nameText;
private String  text;

private String currentColor = "";

    public String getNameText() {
        return nameText;
    }

    public String getCurrentColor() {
        return currentColor;
    }
    void saveCurrentColor(String s) {
        currentColor =s;
    }
    public  void setNameText(String name) {
        nameText= name;
    }


    String loadText() {
        return text;
    }
    String loadCurrentColor() {
        return currentColor;
    }
    void saveText(String s) {
        text =s;
    }

@Override
    protected  void onCleared() {

    }
}

//test