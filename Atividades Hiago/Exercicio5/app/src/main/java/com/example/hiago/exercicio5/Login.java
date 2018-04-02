package com.example.hiago.exercicio5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiago.exercicio5.fw.SharedPreferencesHelper;
import com.example.hiago.exercicio5.task.LoginTask;
import com.example.hiago.exercicio5.to.TOBase;
import com.example.hiago.exercicio5.to.TOUsuario;


public class Login extends ActionBarActivity implements View.OnClickListener{

    private Button botaoEntrar;
    private EditText txtUsuario;
    private EditText txtSenha;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botaoEntrar = (Button)findViewById(R.id.btEntrar);
        txtUsuario = (EditText)findViewById(R.id.etUsuario);
        txtSenha = (EditText)findViewById(R.id.etSenha);

        botaoEntrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        pd = new ProgressDialog(this);
        pd.setMessage("Entrando...");
        pd.show();

        String usuario = txtUsuario.getText().toString();
        String senha = txtSenha.getText().toString();
        LoginTask login = new LoginTask(){
            @Override
            protected void onPostExecute(TOBase toBase) {
                pd.hide();

                if(toBase!=null){
                    TOUsuario u = (TOUsuario)toBase;
                    if(u.getSucesso()){

                        SharedPreferencesHelper.write(Login.this, "user_preferences", "user", u.toString());
                        Exemplo5Application.getInstance().setToUsuario(u);

                        Intent i = new Intent(Login.this, Home.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(Login.this, "Usuaário e/ou Senha inválido", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        };
        login.execute(usuario, senha);
    }

}
