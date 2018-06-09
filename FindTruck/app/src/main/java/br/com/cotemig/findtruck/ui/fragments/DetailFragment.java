package br.com.cotemig.findtruck.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.cotemig.findtruck.R;
import br.com.cotemig.findtruck.model.ModelFoodTruck;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    @BindView(R.id.nome)
    TextView nome;

    ModelFoodTruck m;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(ModelFoodTruck m){
        DetailFragment f = new DetailFragment();
        f.m = m;
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);

        ButterKnife.bind(this, view);

        nome.setText(m.getName());

        return view;
    }

}
