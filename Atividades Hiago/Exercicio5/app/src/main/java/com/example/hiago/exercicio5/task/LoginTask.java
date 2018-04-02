package com.example.hiago.exercicio5.task;

import android.os.AsyncTask;

import com.example.hiago.exercicio5.fw.Util;
import com.example.hiago.exercicio5.to.TOBase;
import com.example.hiago.exercicio5.to.TOUsuario;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hiago on 22/05/2015.
 */
public class LoginTask extends AsyncTask<String, Void, TOBase>{

    @Override
    protected TOBase doInBackground(String... params) {

        String usuario = params[0];
        String senha = params[1];

        TOUsuario u = null;

        try{
            String dados = "usuario="+usuario+"&senha="+senha;

            //Criando objeto URL com url do serviço
            URL url = new URL("http://apiexemplo.fourtime.com/services/usuario/autenticar");
            //Criando objeto http e abrindo a conexão
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            //Setando Content-Type e Charset da requisição
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            http.setRequestProperty("Content-Length", Integer.toString(dados.length()));

            http.setReadTimeout(15000);
            http.setConnectTimeout(15000);
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream os = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(dados);
            writer.flush();
            writer.close();

            //Recebendo resposta da requisição

            InputStream i = new BufferedInputStream(http.getInputStream());
            //Convertendo InputStream em String
            String result = Util.readString(i);
            //Transformando resposta de JSON para Objeto Java
            u = TOUsuario.createByJson(result, TOUsuario.class);

        }catch (Exception e){
            u = null;
        }

        return u;
    }
}
