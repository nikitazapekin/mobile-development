package com.example.lab9;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new MyServer(this));


        if (getLifecycle() .getCurrentState() == Lifecycle.State.RESUMED) {


        }
        if (getLifecycle() .getCurrentState() .isAtLeast (Lifecycle.State.STARTED)) {


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

/*
    public class MyServer {
        public void connect () {


        }

        public void disconnect () {

        }

        @Override
        protected void onStart() {
            super.onStart () ;
            myServer.connect () ;

        }

        @Override
        protected void onStop() {
            super.onStop() ;
            myServer.disconnect () ;

        }

 */
}



/*
package com.example.lab9;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
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
//
}
@OnLifecycleEvent (Lifecycle.Event.ON_ANY)
void onAny(LifecycleOwner source, Lifecycle.Event event) {
    Toast.makeText(context, "onAny() method executed: " + event.name(), Toast.LENGTH_SHORT).show();
}



}

 */
/*
public class MyServer {
}


 */