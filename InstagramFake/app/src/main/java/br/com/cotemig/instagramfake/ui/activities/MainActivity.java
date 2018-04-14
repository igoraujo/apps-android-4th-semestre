package br.com.cotemig.instagramfake.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import br.com.cotemig.instagramfake.R;
import br.com.cotemig.instagramfake.app.InstagramFakeApplication;
import br.com.cotemig.instagramfake.model.ModelList;
import br.com.cotemig.instagramfake.services.ServiceFeed;
import br.com.cotemig.instagramfake.ui.adapters.AdapterFeed;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        ServiceFeed s = InstagramFakeApplication.getInstance().getServiceFeed();
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
