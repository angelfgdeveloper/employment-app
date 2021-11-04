package com.angelfgdeveloper.manresapp.utils;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;

public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance(){
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
//        splashTimeClock();
    }

    private void splashTimeClock() {
        SystemClock.sleep(900);
    }
}
