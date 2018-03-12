package com.igor.zeplin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.igor.zeplin.Adapter.ItensAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoppingCartActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    List<String> itens;
    List<String> descriptions;
    List<String> price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        ButterKnife.bind(this);

        descriptions = new ArrayList<>();
        descriptions.add("White Shirt");
        descriptions.add("Nike Sneakers");
        descriptions.add("Simple T-Shirt");
        descriptions.add("Blac Cap");

        price = new ArrayList<>();
        price.add("$ 43.00");
        price.add("$ 95.99");
        price.add("$ 4.99");
        price.add("$ 8.45");

        ItensAdapter adapter = new ItensAdapter(this, descriptions);

        lista.setAdapter(adapter);

    }

}
