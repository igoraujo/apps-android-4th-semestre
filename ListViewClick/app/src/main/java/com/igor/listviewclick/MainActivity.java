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
    ListView listaCidade;

    List<String> estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        estados = new ArrayList<>();

        estados.add(1,"AC");
        estados.add(2,"AL");
        estados.add(3,"AM");
        estados.add(4,"AP");
        estados.add(5,"BA");
        estados.add(6,"CE");
        estados.add(27,"DF");
        estados.add(7,"ES");
        estados.add(8,"GO");
        estados.add(9,"MA");
        estados.add(10,"MG");
        estados.add(11,"MS");
        estados.add(12,"MT");
        estados.add(13,"PA");
        estados.add(14,"PB");
        estados.add(15,"PE");
        estados.add(16,"PI");
        estados.add(17,"PR");
        estados.add(18,"RJ");
        estados.add(19,"RN");
        estados.add(20,"RO");
        estados.add(21,"RR");
        estados.add(22,"RS");
        estados.add(23,"SC");
        estados.add(24,"SE");
        estados.add(25,"SP");
        estados.add(26,"TO");

        EstadoAdapter estadoAdapter = new EstadoAdapter(this, estados);
        lista.setAdapter(estadoAdapter);




    }
}
