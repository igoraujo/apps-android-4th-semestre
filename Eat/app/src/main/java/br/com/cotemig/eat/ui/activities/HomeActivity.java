package br.com.cotemig.eat.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.cotemig.eat.R;
import br.com.cotemig.eat.ui.fragments.DetailFragment;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        setFragment(DetailFragment.newInstance());
    }

    public void setFragment(Fragment f){
        FragmentTransaction fb = getSupportFragmentManager().beginTransaction();
        fb.replace(R.id.homeFragment, f);
        fb.commit();
    }

}
