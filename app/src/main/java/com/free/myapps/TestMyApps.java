package com.free.myapps;

import android.app.Application;
import android.content.Context;

/**
 * Created by JonathanEKSI on 14/02/2019.
 */

public class TestMyApps extends Application {
    public static final String TAG = TestMyApps.class.getSimpleName();
    private static Context context;
    private static TestMyApps mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        TestMyApps.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return TestMyApps.context;
    }

    public static synchronized TestMyApps getInstance() {
        return mInstance;
    }
}
