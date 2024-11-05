

package com.example.lab9;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import kotlin.jvm.functions.Function1;

public class DataController {

    private static DataController instance;


    private final MutableLiveData<Car> liveData = new MutableLiveData<>();

    private final MediatorLiveData<Car> mediatorLiveData = new MediatorLiveData<>();

    private DataController() {
        // источник для медиаторного LiveData
        mediatorLiveData.addSource(liveData, new Observer<Car>() {
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

    // Метод для получения текущего объекта Car
    public LiveData<Car> getData() {
        return liveData;
    }


    public void setData(Car car) {
        liveData.setValue(car);
    }

    // Метод для получения медиаторного LiveData
    public LiveData<Car> getMediatorLiveData() {
        return mediatorLiveData;
    }



}

/*
package com.example.lab9;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import kotlin.jvm.functions.Function1;

public class DataController {

    private static DataController instance;

    private final MutableLiveData<Long> liveDataId = new MutableLiveData<>();

private  Car car;

   // private final MutableLiveData<Car> liveData = new MutableLiveData<>();




    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }

    public LiveData<Car> getData() {
        return car;
    }


    public void setData(Car car) {
      //  liveData.setValue(car);
        car.setValue(car);
    }

    public LiveData<Integer> getLiveDataInt() {
        return (LiveData<Integer>) Transformations.map(liveData, new Function1<String, Integer>() {
            @Override
            public Integer invoke(String input) {
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        });
    }

    private LiveData<Car> getUser(Car id) {
        MutableLiveData<Car> userLiveData = new MutableLiveData<>();

        return userLiveData;
    }

  //  public LiveData<Car> liveDataUser = (LiveData<Car>) Transformations.switchMap(liveDataId, new Function1<Car, LiveData<Car>>() {

    //    public LiveData<Car> invoke(Car id) {
     //         return getUser(id);
     //   }
   // });



   // private final MutableLiveData<String> liveDatal = new MutableLiveData<>();
    //  private final MutableLiveData<String> liveData2 = new MutableLiveData<>();
    private final MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

    private final MutableLiveData<Car> liveData = new MutableLiveData<>();
    public DataController() {
        mediatorLiveData.addSource(liveData, new Observer<Car>() {
            @Override
            public void onChanged(@Nullable Car s) {
                mediatorLiveData.setValue(s);

            }
        });





    }



    public LiveData<String> getMediatorLiveData() {
        return mediatorLiveData;
    }
}
*/
/*
package com.example.lab9;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
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
                    return 0;
                }
            }
        });
    }

    public static class User {

    }

    private LiveData<User> getUser(Long id) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();
      
        return userLiveData;
    }

    public LiveData<User> liveDataUser = Transformations.switchMap(liveDataId, new Function1<Long, LiveData<User>>() {
        @Override
        public LiveData<User> invoke(Long id) {
            return getUser(id);
        }
    });

    private final MutableLiveData<String> liveDatal = new MutableLiveData<>();
    private final MutableLiveData<String> liveData2 = new MutableLiveData<>();
    private final MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

    public DataController() {
        mediatorLiveData.addSource(liveDatal, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mediatorLiveData.setValue(s);
             
            }
        });

        mediatorLiveData.addSource(liveData2, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mediatorLiveData.setValue(s);
            }
        });





    }



    public LiveData<String> getMediatorLiveData() {
        return mediatorLiveData;
    }
}
*/




