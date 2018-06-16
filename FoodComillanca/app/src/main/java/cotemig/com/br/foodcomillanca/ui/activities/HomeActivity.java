package cotemig.com.br.foodcomillanca.ui.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import cotemig.com.br.foodcomillanca.R;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

         FragmentTransaction fb = getSupportFragmentManager().beginTransaction();
         fb.replace(R.id.listaFood, ListFoodTruckFragment.newInstance());
         fb.commit();
    }





}
