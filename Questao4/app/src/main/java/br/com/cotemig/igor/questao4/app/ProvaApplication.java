package br.com.cotemig.igor.questao4.app;

import android.app.Application;

import br.com.cotemig.igor.questao4.services.IServiceProva;
import br.com.cotemig.igor.questao4.services.RestService;

/**
 * Created by 71600388 on 16/04/2018.
 */

public class ProvaApplication  extends Application {

    private static String URL = "http://apiteste.fourtime.com/api/";

    private IServiceProva serviceProva;

    private static ProvaApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createService();
    }

    private void createService() {
        serviceProva = (new RestService(URL)).getService(IServiceProva.class);
    }

    public IServiceProva getServiceProva() {
        return serviceProva;
    }

    public static ProvaApplication getInstance() {
        return instance;
    }
}
