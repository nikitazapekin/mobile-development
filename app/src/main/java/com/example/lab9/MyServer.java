package com.example.lab9;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyServer implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {

//
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnect() {

//
    }
    @OnLifecycleEvent (Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner source, Lifecycle.Event event) {

    }
}
/*
public class MyServer {
}


 */