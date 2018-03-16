package com.igor.listviewclick;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.igor.listviewclick.Adapter.CidadeAdapter;
import com.igor.listviewclick.Adapter.EstadoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    List<String> estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        estados = new ArrayList<>();

        estados.add("AC");
        estados.add("AL");
        estados.add("AM");
        estados.add("AP");
        estados.add("BA");
        estados.add("CE");
        estados.add("DF");
        estados.add("ES");
        estados.add("GO");
        estados.add("MA");
        estados.add("MG");
        estados.add("MS");
        estados.add("MT");
        estados.add("PA");
        estados.add("PB");
        estados.add("PE");
        estados.add("PI");
        estados.add("PR");
        estados.add("RJ");
        estados.add("RN");
        estados.add("RO");
        estados.add("RR");
        estados.add("RS");
        estados.add("SC");
        estados.add("SE");
        estados.add("SP");
        estados.add("TO");

        EstadoAdapter estadoAdapter = new EstadoAdapter(this, estados);
        lista.setAdapter(estadoAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, CidadesActivity.class);

                intent.putExtra("uf", position);

                startActivity(intent);
            }
        });

    }

}
