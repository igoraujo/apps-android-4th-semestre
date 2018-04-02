package br.com.cotemig.hiagoexercicio2.service;
import br.com.cotemig.hiagoexercicio2.model.ListFeed;
import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by Hiago on 19/06/2017.
 */
public interface ServiceFeed {
    @GET("feed/obter/")
    Call<ListFeed> getFeed();
}
