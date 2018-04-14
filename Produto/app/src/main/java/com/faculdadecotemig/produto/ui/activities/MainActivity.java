package com.faculdadecotemig.produto.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.faculdadecotemig.produto.R;
import com.faculdadecotemig.produto.app.ProdutoApplication;
import com.faculdadecotemig.produto.models.ModelProdutoList;
import com.faculdadecotemig.produto.services.ServiceProduto;
import com.faculdadecotemig.produto.ui.adapters.AdapterProduto;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getProduto();
    }

    private void getProduto() {
        ServiceProduto s = ProdutoApplication.getInstance().getServiceProduto();
        Call<ModelProdutoList> call = s.list();

        call.enqueue(new Callback<ModelProdutoList>() {
            @Override
            public void onResponse(Call<ModelProdutoList> call, Response<ModelProdutoList> response) {
                if(response.code() == 200){
//                    Toast.makeText(MainActivity.this, "Quantidade: " + response.body().getLista().size(), Toast.LENGTH_LONG).show();

                    AdapterProduto adapter = new AdapterProduto(response.body().getList(), MainActivity.this);
                    list.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ModelProdutoList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ops!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
