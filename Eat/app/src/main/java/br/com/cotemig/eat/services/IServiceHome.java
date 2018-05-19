package br.com.cotemig.eat.services;

import br.com.cotemig.eat.models.ModeloHome;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 71600388 on 18/05/2018.
 */

public interface IServiceHome  {
    @POST("colocar certo")
    Call<ModeloHome> auth(@Body ModeloHome home);
}
