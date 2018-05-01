package cotemig.com.br.foodcomillanca.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cotemig.com.br.foodcomillanca.R;
import cotemig.com.br.foodcomillanca.app.FoodComillancaApplication;
import cotemig.com.br.foodcomillanca.model.ModelUser;
import cotemig.com.br.foodcomillanca.service.ServiceUser;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editUsuario)
    EditText editUsuario;

    @BindView(R.id.senhaEdit)
    EditText senhaEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEntrar)
    public void loginClick(){
        auth();
    }


    @OnClick(R.id.btnEsqueci)
    public void forgot (View view){
        Intent intent = new Intent(this, ForgotActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnCadastrese)
    public void register (View view){
        Intent intent = new Intent(this, NovaContaActivity.class);
        startActivity(intent);
    }



    private void auth(){

        ServiceUser s = FoodComillancaApplication.getInstance().getServiceUser();

        ModelUser m = new ModelUser();
        m.setUser(editUsuario.getText().toString());
        m.setPassword(senhaEdit.getText().toString());

        retrofit2.Call<ModelUser> call = s.auth(m);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(retrofit2.Call<ModelUser> call, Response<ModelUser> response) {
                if(response.code() == 200){
                    Toast.makeText(MainActivity.this, "Tudo certo", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Ops", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ModelUser> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ops tenso", Toast.LENGTH_SHORT).show();

            }
        });







    }




}
