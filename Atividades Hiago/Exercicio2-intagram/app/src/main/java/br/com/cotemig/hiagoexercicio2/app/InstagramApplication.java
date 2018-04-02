package br.com.cotemig.hiagoexercicio2.app;

import android.app.Application;
import br.com.cotemig.hiagoexercicio2.service.ServiceRestFeed;
/**
 * Created by Hiago on 19/06/2017.
 */
public class InstagramApplication extends Application {
    private static InstagramApplication instance;
    private ServiceRestFeed service;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createRestService();
    }
    public void createRestService(){
        service = new ServiceRestFeed("http://apiteste.fourtime.com/api/");
    }
    public static InstagramApplication getInstance() {
        return instance;
    }
    public ServiceRestFeed getService() {
        return service;
    }
}
