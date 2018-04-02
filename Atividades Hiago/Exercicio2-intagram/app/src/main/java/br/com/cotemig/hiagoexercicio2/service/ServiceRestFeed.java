package br.com.cotemig.hiagoexercicio2.service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Hiago on 19/06/2017.
 */
public class ServiceRestFeed {
    private ServiceFeed feed;
    public ServiceRestFeed(String endPoint) {
        Gson gson = new GsonBuilder().
                setLenient().
                create();
        Retrofit adapter = new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
        feed = adapter.create(ServiceFeed.class);
    }
    public ServiceFeed getFeed() {
        return feed;
    }
}
