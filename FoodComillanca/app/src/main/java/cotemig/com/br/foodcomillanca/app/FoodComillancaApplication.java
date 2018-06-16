package cotemig.com.br.foodcomillanca.app;

import android.app.Application;

import cotemig.com.br.foodcomillanca.service.RestService;
import cotemig.com.br.foodcomillanca.service.ServiceFoodtruck;
import cotemig.com.br.foodcomillanca.service.ServiceUser;

public class FoodComillancaApplication extends Application{

    private static String URL = "http://api.foodtruck.fourtime.com/";

    private  static FoodComillancaApplication instance;

    private ServiceUser serviceUser;
    private ServiceFoodtruck serviceFood;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices() {
        serviceFood = (new RestService(URL)).getService(ServiceFoodtruck.class);
        serviceUser = (new RestService(URL)).getService(ServiceUser.class);

    }

    public static FoodComillancaApplication getInstance() {
        return instance;
    }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }

    public ServiceFoodtruck getServiceFood() {
        return serviceFood;
    }
}
