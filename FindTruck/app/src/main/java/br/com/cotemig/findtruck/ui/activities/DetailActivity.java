package br.com.cotemig.findtruck.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import br.com.cotemig.findtruck.R;
import br.com.cotemig.findtruck.model.ModelFoodTruck;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.nome)
    TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        ModelFoodTruck m = (ModelFoodTruck) getIntent().getSerializableExtra("item");
        nome.setText(m.getName());

    }

}
