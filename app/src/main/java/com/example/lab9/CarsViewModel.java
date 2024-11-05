package com.example.lab9;



import androidx.lifecycle.ViewModel;

public class CarsViewModel extends ViewModel {

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

    public  int loadCarLogo() {
        return currentCar.getLogo();
    }
    public int loadCarPrice() {
        return currentCar != null ? currentCar.getPrice() : 0;
    }


    void saveCurrentName(String s) {

    }
    @Override
    protected void onCleared() {

    }
}