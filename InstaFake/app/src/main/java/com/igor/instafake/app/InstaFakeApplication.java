package com.igor.instafake.app;

import android.app.Application;

import com.igor.instafake.service.IServiceFeed;
import com.igor.instafake.service.ServiceRest;

/**
 * Created by 71600388 on 02/04/2018.
 */

public class InstaFakeApplication extends Application {

    private static String URL = "http://apiteste.fourtime.com/api/";

    private IServiceFeed serviceFeed;

    private static InstaFakeApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createService();
    }
    private void createService(){
        serviceFeed = (new ServiceRest(URL)).getService(IServiceFeed.class);
    }

    public static InstaFakeApplication getInstance() {
        return instance;
    }

    public IServiceFeed getServiceFeed() {
        return serviceFeed;
    }

}
