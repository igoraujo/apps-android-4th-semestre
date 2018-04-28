package br.com.cotemig.eat.app;

import android.app.Application;

import br.com.cotemig.eat.services.IServiceUser;
import br.com.cotemig.eat.services.RestService;

/**
 * Created by 71600388 on 27/04/2018.
 */

public class EatApplicarion extends Application {

    private static final String URL = "http://private-d37d8-findtruck.apiary-mock.com/";

    private static EatApplicarion instance;

    private IServiceUser serviceUser;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices(){
        serviceUser = (new RestService(URL)).getService(IServiceUser.class);
    }

    public static EatApplicarion getInstance() {
        return instance;
    }

    public IServiceUser getServiceUser() {
        return serviceUser;
    }

}
