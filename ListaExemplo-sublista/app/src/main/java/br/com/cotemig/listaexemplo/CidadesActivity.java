package br.com.cotemig.listaexemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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

        ButterKnife.bind(this);

        String estado = getIntent().getStringExtra("estado");

        cidades = new ArrayList<>();

        if(estado.equals("AC")) {
            cidades.add("Rio Branco");
        }else if(estado.equals("MG")) {
            cidades.add("Belo Horizonte");
            cidades.add("Betim");
            cidades.add("Contagem");
        }else if(estado.equals("RJ")) {
            cidades.add("Rio de Janeiro");
        }

        CidadeAdapter adapter = new CidadeAdapter(this, cidades);
        lista.setAdapter(adapter);

    }
}
