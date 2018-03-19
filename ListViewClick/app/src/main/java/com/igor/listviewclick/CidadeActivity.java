package com.igor.listviewclick;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.igor.listviewclick.Adapter.CidadeAdapter;
import com.igor.listviewclick.EstadosCidades.AC;
import com.igor.listviewclick.EstadosCidades.AL;
import com.igor.listviewclick.EstadosCidades.AM;
import com.igor.listviewclick.EstadosCidades.AP;
import com.igor.listviewclick.EstadosCidades.BA;
import com.igor.listviewclick.EstadosCidades.CE;
import com.igor.listviewclick.EstadosCidades.DF;
import com.igor.listviewclick.EstadosCidades.ES;
import com.igor.listviewclick.EstadosCidades.GO;
import com.igor.listviewclick.EstadosCidades.MA;
import com.igor.listviewclick.EstadosCidades.MG;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CidadeActivity extends AppCompatActivity {

    @BindView(R.id.listaCidade)
    ListView listaCidade;

    List<String> cidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidade);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String uf = intent.getStringExtra("uf");

        cidades = new ArrayList<>();

        switch (uf){
            case "0":
                AC ac = new AC();
                cidades = ac.getCidades();
                break;
            case "1":
                AL al = new AL();
                cidades = al.getCidades();
                break;
            case "2":
                AM am = new AM();
                cidades = am.getCidades();
                break;
            case "3":
                AP ap = new AP();
                cidades = ap.getCidades();
                break;
            case "4":
                BA ba = new BA();
                cidades = ba.getCidades();
                break;
            case "5":
                CE ce = new CE();
                cidades = ce.getCidades();
                break;
            case "6":
                DF df = new DF();
                cidades = df.getCidades();
                break;
            case "7":
                ES es = new ES();
                cidades = es.getCidades();
                break;
            case "8":
                GO go = new GO();
                cidades = go.getCidades();
                break;
            case "9":
                MA ma = new MA();
                cidades = ma.getCidades();
                break;
            case "10":
                MG mg = new MG();
                cidades = mg.getCidades();
                break;
            default:
                cidades.add("NAO LISTADO!!!");
                break;
        }

        CidadeAdapter cidadeAdapter = new CidadeAdapter(this, cidades);
        listaCidade.setAdapter(cidadeAdapter);

        listaCidade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Context context = getApplicationContext();
                CharSequence text = String.valueOf(position);
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, cidades.get(position), duration);
                toast.show();
            }
        });

    }
}