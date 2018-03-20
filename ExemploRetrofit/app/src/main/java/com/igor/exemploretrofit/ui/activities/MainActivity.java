package com.igor.exemploretrofit.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.igor.exemploretrofit.R;
import com.igor.exemploretrofit.app.ExemploRetrofitApplication;
import com.igor.exemploretrofit.model.ListaProdutoModel;
import com.igor.exemploretrofit.service.ProdutoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProdutoService produtoService = ExemploRetrofitApplication.getInstance().getProdutoService();
        Call<ListaProdutoModel> call = produtoService.lista();

        call.enqueue(new Callback<ListaProdutoModel>() {
            @Override
            public void onResponse(Call<ListaProdutoModel> call, Response<ListaProdutoModel> response) {

                Toast.makeText(MainActivity.this, "Itens na Lista" + response.body().getLista().size(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<ListaProdutoModel> call, Throwable t) {

            }
        });

    }
}
