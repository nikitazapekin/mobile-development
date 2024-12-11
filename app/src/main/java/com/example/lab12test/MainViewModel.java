
package com.example.lab12test;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;



import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

public class MainViewModel extends ViewModel {






















    private final HumanDao humanDao = App.getInstance().getDatabase().humanDao();
    private final HorseDao horseDao = App.getInstance().getDatabase().horseDao();

    // Получить всех людей
    public LiveData<List<Human>> getHumans() {
        return humanDao.getAll();
    }

    // Получить все лошади по id хозяина
    public LiveData<List<Horse>> getHorsesByOwner(long ownerId) {
        return horseDao.getAllByOwnerId(ownerId);
    }

    // Вставить нового человека
    public void insertHuman(Human human) {
        Executors.newSingleThreadExecutor().execute(() -> humanDao.insert(human));
    }

    // Обновить данные человека
    public void updateHuman(Human human) {
        Executors.newSingleThreadExecutor().execute(() -> humanDao.update(human));
    }

    // Удалить человека
    public void deleteHuman(Human human) {
        Executors.newSingleThreadExecutor().execute(() -> humanDao.delete(human));
    }

    // Вставить новую лошадь
    public void insertHorse(Horse horse) {
        Executors.newSingleThreadExecutor().execute(() -> horseDao.insert(horse));
    }

    // Обновить данные лошади
    public void updateHorse(Horse horse) {
        Executors.newSingleThreadExecutor().execute(() -> horseDao.update(horse));
    }

    // Удалить лошадь
    public void deleteHorse(Horse horse) {
        Executors.newSingleThreadExecutor().execute(() -> horseDao.delete(horse));
    }



}