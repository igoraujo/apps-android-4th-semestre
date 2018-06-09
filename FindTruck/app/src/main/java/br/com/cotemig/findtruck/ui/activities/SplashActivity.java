package br.com.cotemig.findtruck.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.cotemig.findtruck.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    public void init(){
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
//               Intent i = new Intent(SplashActivity.this, MainActivity.class);
                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
               startActivity(i);
               finish();
            }
        }, 2000);
    }
}
