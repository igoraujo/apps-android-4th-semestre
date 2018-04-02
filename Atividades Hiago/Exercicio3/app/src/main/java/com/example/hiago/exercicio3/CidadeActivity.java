package com.example.hiago.exercicio3;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.example.hiago.exercicio3.adapter.AdapterCidade;
import com.example.hiago.exercicio3.adapter.AdapterEstado;
import com.example.hiago.exercicio3.to.Cidade;
import com.example.hiago.exercicio3.to.Estado;
import java.util.ArrayList;
import java.util.List;
public class CidadeActivity extends ActionBarActivity {
    private List<Cidade> listaTodos;
    private List<Cidade> listaFiltrada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidade);
        listaTodos = new ArrayList<>();
        listaFiltrada = new ArrayList<>();
        listaTodos.add(new Cidade(1,1, "Belo Horizonte"));
        listaTodos.add(new Cidade(1,2, "Uberlandia"));
        listaTodos.add(new Cidade(1,3, "Uberaba"));
        listaTodos.add(new Cidade(2,1, "São Paulo"));
        listaTodos.add(new Cidade(2,2, "Ribeirão Preto"));
        listaTodos.add(new Cidade(2,3, "Campinas"));
        listaTodos.add(new Cidade(3,1, "Buzios"));
        listaTodos.add(new Cidade(3,2, "Cabo Frio"));
        listaTodos.add(new Cidade(3,3, "Raial do Cabo"));
        int codigo = getIntent().getIntExtra("codigoestado",0);
        for (Cidade c:listaTodos){
            if (c.getCodigoEstado()==codigo){
                listaFiltrada.add(c);
            }
        }
        AdapterCidade adapter = new AdapterCidade(listaFiltrada, this);
        ListView listView = (ListView)findViewById(R.id.listCidade);
        listView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cidade, menu);
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
