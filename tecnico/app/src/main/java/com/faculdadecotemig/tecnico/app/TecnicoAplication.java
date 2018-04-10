package com.faculdadecotemig.tecnico.app;

import android.app.Application;

/**
 * Created by 71600388 on 09/04/2018.
 */

public class TecnicoAplication extends Application{

    private static String URL = "http://apiteste.fourtime.com/api/tecnico/lista";


    private static TecnicoAplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createService();
    }

    private void createService(){
//        serviceFeed = (new RestService(URL)).getService(ServiceFeed.class);
    }

    public static TecnicoAplication getInstance() {
        return instance;
    }

//    public ServiceFeed getServiceFeed() {
//        return serviceFeed;
//    }

}
