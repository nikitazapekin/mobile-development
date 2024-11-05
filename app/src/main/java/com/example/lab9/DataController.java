

package com.example.lab9;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import kotlin.jvm.functions.Function1;

public class DataController {

    private static DataController instance;


    private final MutableLiveData<Car> liveData = new MutableLiveData<>();
    private final MutableLiveData<Car> liveData1 = new MutableLiveData<>();
    private final MediatorLiveData<Car> mediatorLiveData = new MediatorLiveData<>();

    private DataController() {

        mediatorLiveData.addSource(liveData, new Observer<Car>() {
            @Override
            public void onChanged(@Nullable Car car) {
                mediatorLiveData.setValue(car);
            }
        });


        mediatorLiveData.addSource(liveData1, new Observer<Car>() {
            @Override
            public void onChanged(@Nullable Car car) {
                mediatorLiveData.setValue(car);
            }
        });
    }

    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }


    public LiveData<Car> getDataScreen1() {
        return liveData;
    }
    public LiveData<Car> getDataScreen2() {
        return liveData1;
    }



    public void setDataForScreen1(Car car) {
        liveData.setValue(car);
    }

    public void setDataForScreen2(Car car) {
        liveData1.setValue(car);
    }


    public LiveData<Car> getMediatorLiveData() {
        return mediatorLiveData;
    }




    public boolean hasActiveObservers() {
        return mediatorLiveData.hasActiveObservers();
    }


    public boolean hasObservers() {
        return mediatorLiveData.hasObservers();
    }


    public void observeForever(Observer<Car> observer) {
        mediatorLiveData.observeForever(observer);
    }


    public void removeObserver(Observer<Car> observer) {
        mediatorLiveData.removeObserver(observer);
    }


    public void removeObservers(LifecycleOwner owner) {
        mediatorLiveData.removeObservers(owner);
    }

}
