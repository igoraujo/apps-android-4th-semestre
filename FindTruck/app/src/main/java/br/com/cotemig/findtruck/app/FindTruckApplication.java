package br.com.cotemig.findtruck.app;

import android.app.Application;

import br.com.cotemig.findtruck.services.RestService;
import br.com.cotemig.findtruck.services.ServiceUser;
import br.com.cotemig.findtruck.services.ServicesFoodTruck;

/**
 * Created by dirceu on 23/04/2018.
 */

public class FindTruckApplication extends Application {

    private static final String URL = "http://api.foodtruck.fourtime.com/";

    private static FindTruckApplication instance;

    private ServiceUser serviceUser;
    private ServicesFoodTruck servicesFoodTruck;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices(){
        serviceUser = (new RestService(URL)).getService(ServiceUser.class);
        servicesFoodTruck = (new RestService(URL)).getService(ServicesFoodTruck.class);
    }

    public static FindTruckApplication getInstance() {
        return instance;
    }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }

    public ServicesFoodTruck getServicesFoodTruck() {
        return servicesFoodTruck;
    }
}
