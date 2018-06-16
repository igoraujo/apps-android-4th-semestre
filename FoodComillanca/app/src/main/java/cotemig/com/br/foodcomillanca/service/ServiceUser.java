package cotemig.com.br.foodcomillanca.service;

import cotemig.com.br.foodcomillanca.model.ModelUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
