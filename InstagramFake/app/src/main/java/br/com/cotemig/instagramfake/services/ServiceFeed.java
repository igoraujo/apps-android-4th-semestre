package br.com.cotemig.instagramfake.services;

import br.com.cotemig.instagramfake.model.ModelList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 71600388 on 26/03/2018.
 */

public interface ServiceFeed {

    @GET("feed/obter")
    Call<ModelList> obter();

}
