package com.igor.instafake.service;

import com.igor.instafake.model.ModelListFeed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 71600388 on 02/04/2018.
 */

public interface IServiceFeed {
    @GET("feed/obter/")
    Call<ModelListFeed> getModelFeed();
}
