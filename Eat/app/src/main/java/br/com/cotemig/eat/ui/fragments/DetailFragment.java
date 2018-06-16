package br.com.cotemig.eat.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import br.com.cotemig.eat.R;

import br.com.cotemig.eat.models.ModelDateail;
import br.com.cotemig.eat.ui.activities.HomeActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.app.ActivityCompat.finishAffinity;


public class DetailFragment extends Fragment {

    @BindView(R.id.nome)
    TextView nome;

    @BindView(R.id.detalhe)
    TextView detalhe;

    ModelDateail m;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(ModelDateail m){
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
        detalhe.setText(m.getDetail());

        return view;
    }


}


