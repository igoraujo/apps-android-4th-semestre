package com.igor.instafake.app;

import android.app.Application;

import com.igor.instafake.R;
import com.igor.instafake.service.ServiceRestFeed;

/**
 * Created by 71600388 on 02/04/2018.
 */

public class InstaFakeApplication extends Application {

    private static InstaFakeApplication instance;
    private ServiceRestFeed service;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createRestService();
    }
    public void createRestService(){
        service = new ServiceRestFeed(String.valueOf(R.string.URI_API));
    }
    public static InstaFakeApplication getInstance() {

        return instance;
    }
    public ServiceRestFeed getService() {

        return service;
    }

}
