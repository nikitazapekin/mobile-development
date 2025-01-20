package com.example.lab12test;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class HorseViewModel extends ViewModel {
    private final HorseDao horseDao;

    public HorseViewModel() {
        horseDao = App.getInstance().getDatabase().horseDao();
    }

    public LiveData<Horse> getHorseById(long horseId) {
        return horseDao.getById(horseId);
    }



}