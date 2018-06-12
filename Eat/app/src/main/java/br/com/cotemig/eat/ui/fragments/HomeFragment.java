package br.com.cotemig.eat.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import br.com.cotemig.eat.R;
import br.com.cotemig.eat.app.EatApplication;
import br.com.cotemig.eat.models.ModelDateail;
import br.com.cotemig.eat.services.IServiceHome;
import br.com.cotemig.eat.ui.activities.HomeActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.list)
    ListView list;

    List<ModelDateail> modelDateails;

    HomeActivity activity;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(HomeActivity activity) {
        HomeFragment f = new HomeFragment();
        f.activity = activity;
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        getFindTrucks();

        return view;
    }

    public void getFindTrucks() {

        IServiceHome s = EatApplication.getInstance().getServiceHome();
        Call<List<ModelDateail>> call = s.lista("");

        call.enqueue(new Callback<List<ModelDateail>>() {
            @Override
            public void onResponse(Call<List<ModelDateail>> call, Response<List<ModelDateail>> response) {

            }

            @Override
            public void onFailure(Call<List<ModelDateail>> call, Throwable t) {

            }

        });

    }

    @OnItemClick(R.id.list)
    public void click(int position) {

        ModelDateail m = modelDateails.get(position);

//        HomeActivity xxx = (HomeActivity) getContext();

        activity.setFragment(DetailFragment.newInstance(m));

//        Intent i = new Intent(getContext(), DetailActivity.class);
//        i.putExtra("item", m);
//        startActivity(i);

    }

}
