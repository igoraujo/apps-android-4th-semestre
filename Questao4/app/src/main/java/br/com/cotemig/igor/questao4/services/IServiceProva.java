package br.com.cotemig.igor.questao4.services;

import br.com.cotemig.igor.questao4.models.ModelList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 71600388 on 16/04/2018.
 */

public interface IServiceProva {

    @GET("prova/71600388")
    Call<ModelList> lista();

}
