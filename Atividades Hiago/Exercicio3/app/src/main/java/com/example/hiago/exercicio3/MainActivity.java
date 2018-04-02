package com.example.hiago.exercicio3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.hiago.exercicio3.adapter.AdapterEstado;
import com.example.hiago.exercicio3.to.Estado;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private List<Estado> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<>();
        lista.add(new Estado(1, "Minas Gerais"));
        lista.add(new Estado(2, "São Paulo"));
        lista.add(new Estado(3, "Rio de Janeiro"));
        AdapterEstado adapter = new AdapterEstado(lista, this);
        ListView listView = (ListView)findViewById(R.id.listEstado);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Estado e = lista.get(position);
        System.out.println(e.getCodigo());
        Intent i = new Intent(this, CidadeActivity.class);
        i.putExtra("codigoestado", e.getCodigo());
        i.putExtra("descricaoestado", e.getDescricao());
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
