package br.com.cotemig.eat.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

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

    List<ModelDateail> listEat;

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDetail();

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    private void getDetail() {
        IServiceHome s = EatApplication.getInstance().getServiceHome();
        Call<List<ModelDateail>> call = s.lista("briga");

        call.enqueue(new Callback<List<ModelDateail>>() {
            @Override
            public void onResponse(Call<List<ModelDateail>> call, Response<List<ModelDateail>> response) {
                if (response.code() == 200) {
                    listEat = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<ModelDateail>> call, Throwable t) {

            }
        });
    }

}
