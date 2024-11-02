package com.example.lab9;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.arch.core.util.Function;

import kotlin.jvm.functions.Function1;

public class DataController {

    private static DataController instance;

    private final MutableLiveData<Long> liveDataId = new MutableLiveData<>();
    private final MutableLiveData<String> liveData = new MutableLiveData<>();

    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }

    public LiveData<String> getData() {
        return liveData;
    }

    // Method to update data
    public void setData(String value) {
        liveData.setValue(value);
    }

    public LiveData<Integer> getLiveDataInt() {
        return Transformations.map(liveData, new Function1<String, Integer>() {
            @Override
            public Integer invoke(String input) {
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    return 0; // Default value in case of parsing error
                }
            }
        });
    }



    public static class User {
        // Поля и методы класса User
    }


    private LiveData<User> getUser(Long id) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();
        // Получение данных пользователя (например, из базы данных)
        // userLiveData.setValue(...); // Установите значение пользователя
        return userLiveData;
    }
    public LiveData<User> liveDataUser = (LiveData<User>) Transformations.switchMap(liveDataId, new Function<Long, LiveData<User>>() {
        @Override
        public LiveData<User> apply(Long id) {
            return getUser(id);
        }


        public void setUserId(Long id) {
            liveDataId.setValue(id);
        }




    });

    /*
    LiveData<Long> liveDataId =

            LiveData<User> liveDataUser = Transformations.switchMap(liveDatalId,
                    new Function<Long, LiveData<User>>() {

                        @Override
                        public LiveData<User> apply(Long id) {
                            return getUser(id);

                        }
                    });
*/

/*
    MutableLiveData<String> liveDatal = new MutableLiveData<>();
    MutableLiveData<String> liveData2 = new MutableLiveData<>();

    MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

mediatorLiveData.addSource(liveDatal, new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            mediatorLiveData.setValue(s);
        }


        mediatorLiveData.addSource(liveData2, new Observer<String>() {

            @Override

            public void onChanged(@Nullable String s) {
                mediatorLiveData.setValue(s);

            }
        });

 */

}
