package cotemig.com.br.foodcomillanca.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cotemig.com.br.foodcomillanca.R;
import cotemig.com.br.foodcomillanca.app.FoodComillancaApplication;
import cotemig.com.br.foodcomillanca.model.ModelFoodtruck;
import cotemig.com.br.foodcomillanca.service.ServiceFoodtruck;
import cotemig.com.br.foodcomillanca.ui.adapters.FoodTruckAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFoodTruckFragment extends Fragment {


    @BindView(R.id.lista)
    ListView lista;

    @BindView(R.id.edit_busca)
    EditText edit_busca;

    public static ListFoodTruckFragment newInstance() {
        ListFoodTruckFragment fragment = new ListFoodTruckFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_food_truck, container, false);

        ButterKnife.bind(this, view);

        obterFoodTrucks();

        return view;


    }

    @OnClick(R.id.buscar)
    public void obterFoodTrucks(){

        ServiceFoodtruck s = FoodComillancaApplication.getInstance().getServiceFood();


        Call<List<ModelFoodtruck>> call = s.foodtruck(edit_busca.getText().toString());

        call.enqueue(new Callback<List<ModelFoodtruck>>() {
            @Override
            public void onResponse(Call<List<ModelFoodtruck>> call, Response<List<ModelFoodtruck>> response) {
                if(response.code() == 200){

                    FoodTruckAdapter adapter = new FoodTruckAdapter(getContext(), response.body());
                    lista.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ModelFoodtruck>> call, Throwable t) {

            }
        });

    }
}
