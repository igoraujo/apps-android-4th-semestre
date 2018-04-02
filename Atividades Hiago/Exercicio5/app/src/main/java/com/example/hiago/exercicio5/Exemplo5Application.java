package com.example.hiago.exercicio5;

import android.app.Application;

import com.example.hiago.exercicio5.to.TOUsuario;

/**
 * Created by hiago on 22/05/2015.
 */
public class Exemplo5Application extends Application {
    public static Exemplo5Application instance;
    public TOUsuario toUsuario;

    public TOUsuario getToUsuario() {
        return toUsuario;
    }

    public void setToUsuario(TOUsuario toUsuario) {
        this.toUsuario = toUsuario;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Exemplo5Application getInstance(){
        return instance;
    }

}
