package com.igor.instafake.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.igor.instafake.R;
import com.igor.instafake.app.InstaFakeApplication;
import com.igor.instafake.model.ModelList;
import com.igor.instafake.service.IServiceFeed;
import com.igor.instafake.ui.adapters.AdapterFeed;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getFeed();
    }

    private void getFeed(){
        IServiceFeed s = InstaFakeApplication.getInstance().getServiceFeed();
        Call<ModelList> call = s.obter();

        call.enqueue(new Callback<ModelList>() {
            @Override
            public void onResponse(Call<ModelList> call, Response<ModelList> response) {
                if(response.code() == 200){
//                    Toast.makeText(MainActivity.this, "Quantidade: " + response.body().getLista().size(), Toast.LENGTH_LONG).show();

                    AdapterFeed adapter = new AdapterFeed(response.body().getLista(), MainActivity.this);
                    lista.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ModelList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ops!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
