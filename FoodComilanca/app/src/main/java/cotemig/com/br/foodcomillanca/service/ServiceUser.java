package cotemig.com.br.foodcomillanca.service;

import cotemig.com.br.foodcomillanca.model.ModelUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by gabri on 27/04/2018.
 */

public interface ServiceUser {

    @POST("auth")
    Call<ModelUser> auth(@Body ModelUser user);




    @POST("register")
    Call<ModelUser> register(@Body ModelUser user);


    @POST("forgot")
    Call<ModelUser> forgot(@Body ModelUser user);


    @GET("auth")
    Call<ModelUser> me();









}
