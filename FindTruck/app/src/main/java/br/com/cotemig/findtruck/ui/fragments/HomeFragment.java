package br.com.cotemig.findtruck.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import br.com.cotemig.findtruck.R;
import br.com.cotemig.findtruck.app.FindTruckApplication;
import br.com.cotemig.findtruck.model.ModelFoodTruck;
import br.com.cotemig.findtruck.services.ServicesFoodTruck;
import br.com.cotemig.findtruck.ui.activities.DetailActivity;
import br.com.cotemig.findtruck.ui.activities.HomeActivity;
import br.com.cotemig.findtruck.ui.adapters.FoodTruckAdapter;
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

    List<ModelFoodTruck> listFoodTruck;

    HomeActivity activity;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(HomeActivity activity){
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

    public void getFindTrucks(){

        ServicesFoodTruck s = FindTruckApplication.getInstance().getServicesFoodTruck();
        Call<List<ModelFoodTruck>> call = s.lista("");

        call.enqueue(new Callback<List<ModelFoodTruck>>() {
            @Override
            public void onResponse(Call<List<ModelFoodTruck>> call, Response<List<ModelFoodTruck>> response) {
                if(response.code() == 200){
                    listFoodTruck = response.body();

                    FoodTruckAdapter adapter = new FoodTruckAdapter(getContext(), listFoodTruck);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ModelFoodTruck>> call, Throwable t) {

            }
        });

    }

    @OnItemClick(R.id.list)
    public void click(int position){

        ModelFoodTruck m = listFoodTruck.get(position);

//        HomeActivity xxx = (HomeActivity) getContext();

        activity.setFragment(DetailFragment.newInstance(m));

//        Intent i = new Intent(getContext(), DetailActivity.class);
//        i.putExtra("item", m);
//        startActivity(i);

    }

}
