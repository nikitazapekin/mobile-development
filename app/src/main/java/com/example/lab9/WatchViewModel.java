package com.example.lab9;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WatchViewModel extends ViewModel {
    private final MutableLiveData<Watch> selectedWatch = new MutableLiveData<>();

    public void selectWatch(Watch watch) {
        selectedWatch.setValue(watch);
    }

    public LiveData<Watch> getSelectedWatch() {
        return selectedWatch;
    }
}



/*
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


*/