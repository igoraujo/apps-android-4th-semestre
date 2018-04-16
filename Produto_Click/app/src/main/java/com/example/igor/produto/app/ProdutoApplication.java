package com.example.igor.produto.app;

import android.app.Application;

import com.example.igor.produto.services.IServiceProduto;
import com.example.igor.produto.services.RestService;

/**
 * Created by Igor on 14/04/2018.
 */

public class ProdutoApplication extends Application {

    private static String URL = "http://apiteste.fourtime.com/api/";

    private IServiceProduto serviceProduto;

    private static ProdutoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createService();
    }

    private void createService() {
        serviceProduto = (new RestService(URL)).getService(IServiceProduto.class);
    }

    public IServiceProduto getServiceProduto() {
        return serviceProduto;
    }

    public static ProdutoApplication getInstance() {
        return instance;
    }
}
