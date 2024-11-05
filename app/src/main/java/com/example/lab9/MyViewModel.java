
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
/*package com.example.lab9;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private Car currentCar;

    public Car getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Car car) {
        this.currentCar = car;
    }

    public String loadCarName() {
        return currentCar != null ? currentCar.getName() : null;
    }

    public String loadCarDescription() {
        return currentCar != null ? currentCar.getDescribtion() : null;
    }

    public String loadCarFullDescription() {
        return currentCar != null ? currentCar.getFullDescribtion() : null;
    }

public  int loadCarLogo() {}
    public int loadCarPrice() {
        return currentCar != null ? currentCar.getPrice() : 0;
    }

    @Override
    protected void onCleared() {

    }
}
*/
/*
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
 */