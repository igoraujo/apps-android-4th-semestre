package com.igor.listviewclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.igor.listviewclick.Adapter.CidadeAdapter;
import com.igor.listviewclick.Adapter.EstadoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CidadesActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    List<String> cidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidades);

        Intent intent = getIntent();
        int uf = Integer.parseInt(intent.getStringExtra("uf"));

        ButterKnife.bind(this);

        cidades = new ArrayList<>();

        switch (uf){
            case 0:
                cidades.add("AC");
                cidades.add("AC");
                cidades.add("AC");
                cidades.add("AC");
                break;

            case 1:
                cidades.add("AL");
                cidades.add("AL");
                cidades.add("AL");
                cidades.add("AL");
                break;

            case 2:
                cidades.add("AM");
                cidades.add("AM");
                cidades.add("AM");
                cidades.add("AM");
                break;
            default:
                cidades.add("NAO SEI...");
                return;

        }

//        cidades.add("AC");
//        cidades.add("AL");
//        cidades.add("AM");
//        cidades.add("AP");
//        cidades.add("BA");
//        cidades.add("CE");
//        cidades.add("DF");
//        cidades.add("ES");
//        cidades.add("GO");
//        cidades.add("MA");
//        cidades.add("MG");
//        cidades.add("MS");
//        cidades.add("MT");
//        cidades.add("PA");
//        cidades.add("PB");
//        cidades.add("PE");
//        cidades.add("PI");
//        cidades.add("PR");
//        cidades.add("RJ");
//        cidades.add("RN");
//        cidades.add("RO");
//        cidades.add("RR");
//        cidades.add("RS");
//        cidades.add("SC");
//        cidades.add("SE");
//        cidades.add("SP");
//        cidades.add("TO");

        CidadeAdapter cidadeAdapter = new CidadeAdapter(this, cidades);
        lista.setAdapter(cidadeAdapter);

    }
}
