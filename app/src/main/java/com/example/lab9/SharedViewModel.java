public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Item> selected =
            new MutableLiveData<Item>() ;

    public void select (Item item) {

        selected.setValue (item) ;
    }

    public LiveData<Item> getSelected() {
        return selected;
    }
/*
package com.example.lab9;


public class SharedViewModel {
}
*/