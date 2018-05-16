package com.example.zll.jingdongrxjava.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by zll on 2018/5/10.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
