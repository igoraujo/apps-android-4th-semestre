package com.igor.instafake.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 71600388 on 02/04/2018.
 */

public class ServiceRestFeed {
    private IServiceFeed iServiceFeed;
    public ServiceRestFeed(String endPoint) {
        Gson gson = new GsonBuilder().
                setLenient().
                create();
        Retrofit adapter = new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
        iServiceFeed = adapter.create(IServiceFeed.class);
    }

    public IServiceFeed getFeed() {
        return iServiceFeed;
    }
}
