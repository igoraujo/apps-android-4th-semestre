package br.com.cotemig.exemploretrofit.app;

import android.app.Application;

import br.com.cotemig.exemploretrofit.service.RestService;
import br.com.cotemig.exemploretrofit.service.ServiceProduto;

/**
 * Created by dirceu on 19/03/2018.
 */

public class ExemploRetrofitApplication extends Application {

    private static String URL_PRODUTO = "http://apiteste.fourtime.com/api/produto/";

    private static ExemploRetrofitApplication instance;

    private ServiceProduto serviceProduto;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices(){
        serviceProduto = (new RestService(URL_PRODUTO)).getService(ServiceProduto.class);
    }

    public static ExemploRetrofitApplication getInstance() {
        return instance;
    }

    public ServiceProduto getServiceProduto() {
        return serviceProduto;
    }
}
