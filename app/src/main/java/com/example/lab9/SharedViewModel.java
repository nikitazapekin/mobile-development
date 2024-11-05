package com.example.lab9;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


//public class Item {

//}
public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> selected =
            new MutableLiveData<String>();

    public void select(String item) {

        selected.setValue(item);
    }

   /* public LiveData<Item> getSelected() {
        return selected;
    } */

}
/*
package com.example.lab9;


public class SharedViewModel {
}
*/