package br.com.cotemig.exemploretrofit.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dirceu on 19/03/2018.
 */

public class RestService {

    private Retrofit adapter;

    public RestService(String endPoint){

        Gson gson = new GsonBuilder().setLenient().create();

        adapter = new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();

    }

    public <T> T getService(Class<T> c){
        return adapter.create(c);
    }

}
