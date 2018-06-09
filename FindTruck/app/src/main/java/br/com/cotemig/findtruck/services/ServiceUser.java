package br.com.cotemig.findtruck.services;

import br.com.cotemig.findtruck.model.ModelUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by dirceu on 23/04/2018.
 */

public interface ServiceUser {

    @POST("user/auth")
    Call<ModelUser> auth(@Body ModelUser user);

    @POST("user")
    Call<ModelUser> register(@Body ModelUser user);

    @POST("user/forgot")
    Call<ModelUser> forgot(@Body ModelUser user);

    @GET("user/me")
    Call<ModelUser> me();

}
