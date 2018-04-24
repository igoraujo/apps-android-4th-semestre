package br.com.cotemig.igor.questao4.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 71600388 on 16/04/2018.
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
