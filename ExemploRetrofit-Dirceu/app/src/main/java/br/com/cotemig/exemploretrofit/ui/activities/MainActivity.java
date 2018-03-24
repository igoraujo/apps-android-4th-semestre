package br.com.cotemig.exemploretrofit.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import br.com.cotemig.exemploretrofit.R;
import br.com.cotemig.exemploretrofit.app.ExemploRetrofitApplication;
import br.com.cotemig.exemploretrofit.model.ModelListaProduto;
import br.com.cotemig.exemploretrofit.service.ServiceProduto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obterProdutos();
    }

    public void obterProdutos(){

        ServiceProduto s = ExemploRetrofitApplication.getInstance().getServiceProduto();
        Call<ModelListaProduto> call = s.lista();

        call.enqueue(new Callback<ModelListaProduto>() {
            @Override
            public void onResponse(Call<ModelListaProduto> call, Response<ModelListaProduto> response) {

                if(response.code() == 200) {
                    Toast.makeText(MainActivity.this, "Itens na lista" + response.body().getLista().size(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<ModelListaProduto> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Itens na lista", Toast.LENGTH_LONG).show();

            }
        });

    }
}
