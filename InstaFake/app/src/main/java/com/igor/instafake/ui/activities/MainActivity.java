package com.igor.instafake.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.igor.instafake.R;
import com.igor.instafake.app.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    List<String> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        itens = new ArrayList<String>();

        itens.add("teste01");
        itens.add("teste02");

        ItemAdapter adapter = new ItemAdapter(this, itens);
        lista.setAdapter(adapter);

    }
}
