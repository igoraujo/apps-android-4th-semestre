package br.com.cotemig.eat.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import br.com.cotemig.eat.R;
import br.com.cotemig.eat.app.EatApplication;
import br.com.cotemig.eat.models.ModelDateail;
import br.com.cotemig.eat.models.ModelDetailList;
import br.com.cotemig.eat.services.IServiceHome;
import br.com.cotemig.eat.ui.activities.HomeActivity;
import br.com.cotemig.eat.ui.adapters.AdapterDetail;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFragment extends Fragment {

    @BindView(R.id.list)
    ListView list;

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_detail, container, false);

        getDetaril();

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    private void getDetaril() {
        IServiceHome s = EatApplication.getInstance().getServiceHome();
        Call<ModelDateail> call = s.lista();

        call.enqueue(new Callback<ModelDateail>() {
            @Override
            public void onResponse(Call<ModelDateail> call, Response<ModelDateail> response) {
                if(response.code() == 200){

                    AdapterDetail adapter = new AdapterDetail(response.body().getDetail(), DetailFragment.this);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ModelDateail> call, Throwable t) {

            }


        });
    }

}
