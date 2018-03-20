package com.igor.exemploretrofit.app;

import android.app.Application;

import com.igor.exemploretrofit.R;
import com.igor.exemploretrofit.service.ProdutoService;
import com.igor.exemploretrofit.service.RestService;

/**
 * Created by 71600388 on 19/03/2018.
 */

public class ExemploRetrofitApplication extends Application {

    private static String URL_PRODUTO = String.valueOf(R.string.URL_PRODUTO);

    private static ExemploRetrofitApplication instance;

    private ProdutoService produtoService;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();
    }

    private void createServices(){
        produtoService = (new RestService(URL_PRODUTO)).getService(ProdutoService.class);
    }

    public static ExemploRetrofitApplication getInstance(){
        return instance;
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }


}
