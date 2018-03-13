package br.com.cotemig.listaexemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

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

        EstadoAdapter adapter = new EstadoAdapter(this, estados);
        lista.setAdapter(adapter);

    }

    @OnItemClick(R.id.lista)
    public void itemClick(int p){

//        Toast.makeText(this, "Clicou no item " + p, Toast.LENGTH_SHORT).show();

        // criando uma inteção para abrir uma activity
        Intent intent = new Intent(this, CidadesActivity.class);
        // passando o parâmetro do estado clicado
        intent.putExtra("estado", estados.get(p));
        // startando uma activity
        startActivity(intent);

        // matando a activity
        //finish();

    }
}

