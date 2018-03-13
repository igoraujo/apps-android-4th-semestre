package com.igor.listviewclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
        estados.add("AM");
        estados.add("AL");
        estados.add("BA");
        estados.add("MG");
        estados.add("RJ");
        estados.add("SP");
        estados.add("BA");
        estados.add("MG");
        estados.add("RJ");
        estados.add("SP");
        estados.add("BA");
        estados.add("MG");
        estados.add("RJ");
        estados.add("SP");
        estados.add("BA");
        estados.add("MG");
        estados.add("RJ");
        estados.add("SP");
        estados.add("BA");
        estados.add("MG");
        estados.add("RJ");
        estados.add("SP");
        estados.add("BA");
        estados.add("MG");
        estados.add("RJ");
        estados.add("SP");
        estados.add("BA");
        estados.add("MG");
        estados.add("RJ");
        estados.add("SP");

        EstadoAdapter estadoAdapter = new EstadoAdapter(this, estados);
        lista.setAdapter(estadoAdapter);

    }
}
