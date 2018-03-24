package br.com.cotemig.exemploretrofit.service;

import br.com.cotemig.exemploretrofit.model.ModelListaProduto;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dirceu on 19/03/2018.
 */

public interface ServiceProduto {

    @GET("lista")
    Call<ModelListaProduto> lista();

}
