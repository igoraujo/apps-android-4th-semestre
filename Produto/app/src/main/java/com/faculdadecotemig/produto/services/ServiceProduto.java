package com.faculdadecotemig.produto.services;

import com.faculdadecotemig.produto.models.ModelProdutoList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 71600388 on 13/04/2018.
 */

public interface ServiceProduto {

    @GET("produto/lista")
    Call<ModelProdutoList> list();
}
