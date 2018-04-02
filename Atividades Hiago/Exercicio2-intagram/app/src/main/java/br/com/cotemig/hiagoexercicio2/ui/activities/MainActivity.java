package br.com.cotemig.hiagoexercicio2.ui.activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import br.com.cotemig.hiagoexercicio2.R;
import br.com.cotemig.hiagoexercicio2.app.InstagramApplication;
import br.com.cotemig.hiagoexercicio2.model.ListFeed;
import br.com.cotemig.hiagoexercicio2.service.ServiceFeed;
import br.com.cotemig.hiagoexercicio2.ui.adapter.AdapterFeed;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by Hiago on 19/06/2017.
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.list)
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getFeed();
    }
    public void getFeed(){
        ServiceFeed s = InstagramApplication.getInstance().getService().getFeed();
        Call<ListFeed> call = s.getFeed();
        call.enqueue(new Callback<ListFeed>() {
            @Override
            public void onResponse(Call<ListFeed> call, Response<ListFeed> response) {
                AdapterFeed adapter = new AdapterFeed(MainActivity.this, response.body().getList());
                list.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ListFeed> call, Throwable t) {
            }
        });
    }
}
