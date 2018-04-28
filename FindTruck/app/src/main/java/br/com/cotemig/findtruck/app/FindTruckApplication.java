package br.com.cotemig.findtruck.app;

import android.app.Application;

import br.com.cotemig.findtruck.services.RestService;
import br.com.cotemig.findtruck.services.ServiceUser;

/**
 * Created by dirceu on 23/04/2018.
 */

public class FindTruckApplication extends Application {

    private static final String URL = "http://private-d37d8-findtruck.apiary-mock.com/";

    private static FindTruckApplication instance;

    private ServiceUser serviceUser;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices(){
        serviceUser = (new RestService(URL)).getService(ServiceUser.class);
    }

    public static FindTruckApplication getInstance() {
        return instance;
    }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }
}
