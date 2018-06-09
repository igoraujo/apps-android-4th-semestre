package br.com.cotemig.findtruck.services;

import java.util.List;

import br.com.cotemig.findtruck.model.ModelFoodTruck;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dirceu on 07/05/2018.
 */

public interface ServicesFoodTruck {

    @GET("foodtruck")
    Call<List<ModelFoodTruck>> lista(@Query("q") String busca);


}
