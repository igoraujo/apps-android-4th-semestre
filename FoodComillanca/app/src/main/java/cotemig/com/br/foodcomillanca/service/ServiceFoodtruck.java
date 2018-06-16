package cotemig.com.br.foodcomillanca.service;

import java.util.List;

import cotemig.com.br.foodcomillanca.model.ModelFoodtruck;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceFoodtruck {

    @GET("foodtruck")
    Call<List<ModelFoodtruck>> foodtruck(@Query("q")String q);




}
