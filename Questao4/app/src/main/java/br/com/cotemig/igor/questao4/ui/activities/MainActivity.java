package br.com.cotemig.igor.questao4.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import br.com.cotemig.igor.questao4.R;
import br.com.cotemig.igor.questao4.app.ProvaApplication;

import br.com.cotemig.igor.questao4.models.ModelList;
import br.com.cotemig.igor.questao4.services.IServiceProva;
import br.com.cotemig.igor.questao4.ui.adapters.AdapterProva;

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

        getProva();

    }

    private void getProva() {

        IServiceProva service = ProvaApplication.getInstance().getServiceProva();
        Call<ModelList> call = service.lista();

        call.enqueue(new Callback<ModelList>() {
            @Override
            public void onResponse(Call<ModelList> call, Response<ModelList> response) {

                if(response.code()==200){

                    AdapterProva adapter = new AdapterProva(response.body().getList(), MainActivity.this);
                    list.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<ModelList> call, Throwable t) {

            }
        });

    }

}
