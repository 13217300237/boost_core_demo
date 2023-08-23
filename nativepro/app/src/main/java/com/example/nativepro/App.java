package com.example.nativepro;

import android.app.Application;


import com.kbz_b.BoostCore;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BoostCore.INSTANCE.init(this);
    }
}
