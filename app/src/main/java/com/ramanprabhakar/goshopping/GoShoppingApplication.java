package com.ramanprabhakar.goshopping;

import android.app.Application;

/**
 * Created by Raman on 5/22/2016.
 */
public class GoShoppingApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpService.getInstance().setUp(getApplicationContext());
    }
}
