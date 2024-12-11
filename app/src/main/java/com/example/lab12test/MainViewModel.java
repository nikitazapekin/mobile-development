
package com.example.lab12test;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;



import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

public class MainViewModel extends ViewModel {


    private final HumanDao humanDao = App.getInstance().getDatabase().humanDao();
    private final HorseDao horseDao = App.getInstance().getDatabase().horseDao();


    public LiveData<List<Human>> getHumans() {
        return humanDao.getAll();
    }


    public LiveData<List<Horse>> getHorsesByOwner(long ownerId) {
        return horseDao.getAllByOwnerId(ownerId);
    }

    public void insertHuman(Human human) {
        Executors.newSingleThreadExecutor().execute(() -> humanDao.insert(human));
    }

    public void updateHuman(Human human) {
        Executors.newSingleThreadExecutor().execute(() -> humanDao.update(human));
    }

    public void deleteHuman(Human human) {
        Executors.newSingleThreadExecutor().execute(() -> humanDao.delete(human));
    }

    public void insertHorse(Horse horse) {
        Executors.newSingleThreadExecutor().execute(() -> horseDao.insert(horse));
    }

    public void updateHorse(Horse horse) {
        Executors.newSingleThreadExecutor().execute(() -> horseDao.update(horse));
    }


    public void deleteHorse(Horse horse) {
        Executors.newSingleThreadExecutor().execute(() -> horseDao.delete(horse));
    }



}