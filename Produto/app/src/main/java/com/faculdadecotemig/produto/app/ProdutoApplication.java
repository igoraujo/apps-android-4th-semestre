package com.faculdadecotemig.produto.app;

import android.app.Application;

import com.faculdadecotemig.produto.R;
import com.faculdadecotemig.produto.services.RestService;
import com.faculdadecotemig.produto.services.ServiceProduto;

/**
 * Created by 71600388 on 13/04/2018.
 */

public class ProdutoApplication extends Application {

    private static String URL = String.valueOf(R.string.URL_API_PRODUTO);

    private ServiceProduto serviceProduto;

    private static  ProdutoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createService();
    }

    private void createService(){
        serviceProduto = (new RestService(URL)).getService(ServiceProduto.class);
    }

    public ServiceProduto getServiceProduto() {
        return serviceProduto;
    }

    public static ProdutoApplication getInstance() {
        return instance;
    }
}
