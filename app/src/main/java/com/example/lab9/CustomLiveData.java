package com.example.lab9;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class CustomLiveData<T> extends MutableLiveData<T> {

    @Override
    public boolean hasActiveObservers() {
        return super.hasActiveObservers();
    }

    @Override
    public boolean hasObservers() {
        return super.hasObservers();
    }

    @Override
    public void observeForever(@NonNull Observer<? super T> observer) {
        super.observeForever(observer);
    }

    @Override
    public void removeObserver(@NonNull Observer<? super T> observer) {
        super.removeObserver(observer);
    }

    @Override
    public void removeObservers(@NonNull LifecycleOwner owner) {
        super.removeObservers(owner);
    }
}


/*
package com.example.lab9;


public class CustomLiveData {
}
*/