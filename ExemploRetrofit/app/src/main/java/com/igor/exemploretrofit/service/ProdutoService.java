package com.igor.exemploretrofit.service;

import com.igor.exemploretrofit.model.ListaProdutoModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 71600388 on 19/03/2018.
 */

public interface ProdutoService {

    @GET("lista")
    Call<ListaProdutoModel> lista();

}
