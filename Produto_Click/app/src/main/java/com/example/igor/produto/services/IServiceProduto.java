package com.example.igor.produto.services;

import com.example.igor.produto.models.ModelList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Igor on 14/04/2018.
 */

public interface IServiceProduto {

    @GET("produto/lista")
    Call<ModelList> lista();

}
