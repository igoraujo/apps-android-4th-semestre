package br.com.cotemig.eat.services;

import br.com.cotemig.eat.models.ModelDateail;
import br.com.cotemig.eat.models.ModelSearch;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 71600388 on 18/05/2018.
 */

public interface IServiceHome {

    @GET("?q=")
    Call<ModelDateail> lista();

    @POST("colocar certo")
    Call<ModelDateail> auth(@Body ModelDateail dateail);

    @POST("colocar certo")
    Call<ModelSearch> auth(@Body ModelSearch search);
}
