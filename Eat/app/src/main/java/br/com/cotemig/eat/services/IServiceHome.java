package br.com.cotemig.eat.services;

import android.support.annotation.StringRes;
import android.support.v4.media.MediaMetadataCompat;

import java.util.List;

import br.com.cotemig.eat.models.ModelDateail;
import br.com.cotemig.eat.models.ModelDetailList;
import br.com.cotemig.eat.models.ModelSearch;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 71600388 on 18/05/2018.
 */

public interface IServiceHome {

    @GET("foodtruck")
    Call<List<ModelDateail>> lista(@Query("q") String q);

}
