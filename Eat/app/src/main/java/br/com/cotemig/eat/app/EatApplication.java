package br.com.cotemig.eat.app;

import android.app.Application;

import br.com.cotemig.eat.services.IServiceHome;
import br.com.cotemig.eat.services.IServiceUser;
import br.com.cotemig.eat.services.RestService;

/**
 * Created by 71600388 on 27/04/2018.
 */

public class EatApplication extends Application {

    private static final String URL = "http://api.foodtruck.fourtime.com/foodtruck/";

    private static EatApplication instance;

    private IServiceUser serviceUser;
    private IServiceHome serviceHome;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices(){
        serviceUser = (new RestService(URL)).getService(IServiceUser.class);
        serviceHome = (new RestService(URL)).getService(IServiceHome.class);
    }

    public static EatApplication getInstance() {
        return instance;
    }

    public IServiceUser getServiceUser() {
        return serviceUser;
    }

    public IServiceHome getServiceHome() {
        return serviceHome;
    }

}
