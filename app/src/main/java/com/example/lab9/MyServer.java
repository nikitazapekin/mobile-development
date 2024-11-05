
package com.example.lab9;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

public class MyServer implements LifecycleObserver {

    private final Context context;

    public MyServer(Context context) {
        this.context = context;
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {
        Toast.makeText(context, "connect() method executed", Toast.LENGTH_SHORT).show();
//
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnect() {
        Toast.makeText(context, "disconnect() method executed", Toast.LENGTH_SHORT).show();

    }
    @OnLifecycleEvent (Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner source, Lifecycle.Event event) {
        Toast.makeText(context, "onAny() method executed: " + event.name(), Toast.LENGTH_SHORT).show();
    }






}