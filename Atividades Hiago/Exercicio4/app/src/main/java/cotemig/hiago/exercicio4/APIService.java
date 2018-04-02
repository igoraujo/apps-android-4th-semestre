package cotemig.hiago.exercicio4;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by hiago on 21/06/2017.
 */
public interface APIService {
    @POST("/posts")
    @FormUrlEncoded
    Call<POST> savePost(@Field("nome") String nome,
                        @Field("email") String email,
                        @Field("senha") String senha);
}
