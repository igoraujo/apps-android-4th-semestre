package cotemig.com.br.foodcomillanca.ui.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cotemig.com.br.foodcomillanca.R;


public class ItemFragment extends Fragment {


    public static ItemFragment newInstance() {
        ItemFragment fragment = new ItemFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_item, container, false);

        ButterKnife.bind(this, view);

        return view;
    }






}
