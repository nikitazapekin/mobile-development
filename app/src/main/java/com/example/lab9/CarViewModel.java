package com.example.lab9;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarViewModel extends ViewModel {
    private final MutableLiveData<Car> selectedCar = new MutableLiveData<>();

    public void selectCar(Car car) {
        selectedCar.setValue(car);
    }

    public LiveData<Car> getSelectedCar() {
        return selectedCar;
    }
}
