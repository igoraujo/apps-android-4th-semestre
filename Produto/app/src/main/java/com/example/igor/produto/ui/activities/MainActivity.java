package com.example.igor.produto.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.igor.produto.R;
import com.example.igor.produto.app.ProdutoApplication;
import com.example.igor.produto.models.ModelList;
import com.example.igor.produto.services.IServiceProduto;
import com.example.igor.produto.ui.adapters.AdapterProduto;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getProduto();
    }

    private void getProduto() {
        IServiceProduto s = ProdutoApplication.getInstance().getServiceProduto();
        Call<ModelList> call = s.lista();

        call.enqueue(new Callback<ModelList>() {
            @Override
            public void onResponse(Call<ModelList> call, Response<ModelList> response) {
                if(response.code() == 200){
//                    Toast.makeText(MainActivity.this, "Quantidade: " + response.body().getLista().size(), Toast.LENGTH_LONG).show();

                    AdapterProduto adapter = new AdapterProduto(response.body().getList(), MainActivity.this);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ModelList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ops!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
