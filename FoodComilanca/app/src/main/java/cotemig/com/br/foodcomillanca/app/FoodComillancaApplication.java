package cotemig.com.br.foodcomillanca.app;

import android.app.Application;

import cotemig.com.br.foodcomillanca.service.RestService;
import cotemig.com.br.foodcomillanca.service.ServiceUser;

/**
 * Created by gabri on 27/04/2018.
 */

public class FoodComillancaApplication  extends Application{

    private static String URL = "http://private-d37d8-findtruck.apiary-mock.com/";

    private  static FoodComillancaApplication instance;

    private ServiceUser serviceUser;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices() {
        serviceUser = (new RestService(URL)).getService(ServiceUser.class);
    }

    public static FoodComillancaApplication getInstance() {
        return instance;
    }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }
}
