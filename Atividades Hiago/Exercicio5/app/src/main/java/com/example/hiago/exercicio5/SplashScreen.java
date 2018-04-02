package com.example.hiago.exercicio5;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hiago.exercicio5.fw.SharedPreferencesHelper;
import com.example.hiago.exercicio5.to.TOUsuario;


public class SplashScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String user = SharedPreferencesHelper.read(this, "user_preferences", "user", null);
        if (user == null){
            abreLogin();
        }else{
            TOUsuario u = TOUsuario.createByJson(user, TOUsuario.class);
            Exemplo5Application.getInstance().setToUsuario(u);

            abreHome();
        }
    }

    private void abreHome(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, 2000);


    }
    private void abreLogin(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 2000);


    }


}
