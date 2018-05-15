package br.com.cotemig.exemplofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setFragment(Teste1Fragment.newInstance());
    }

    @OnClick(R.id.fragment1)
    public void fragment1Click(){
        setFragment(Teste1Fragment.newInstance());
    }

    @OnClick(R.id.fragment2)
    public void fragment2Click(){
        setFragment(Teste2Fragment.newInstance());
    }

    public void setFragment(Fragment f){
        FragmentTransaction fb = getSupportFragmentManager().beginTransaction();
        fb.replace(R.id.centerFragment, f);
        fb.commit();
    }
}
