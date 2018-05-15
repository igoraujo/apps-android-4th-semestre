package br.com.cotemig.exemplofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


public class Teste1Fragment extends Fragment {

    public static Teste1Fragment newInstance() {
        Teste1Fragment fragment = new Teste1Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_teste1, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

}
