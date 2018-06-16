package cotemig.com.br.foodcomillanca.ui.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

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

                    Toast.makeText(MainActivity.this, "deu certo", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);



                }else{
                    new MaterialDialog.Builder(MainActivity.this)
                            .title(R.string.ops)
                            .content(R.string.usuarioInvalido)
                            .positiveText(R.string.ok)
                            .show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ModelUser> call, Throwable t) {

                new MaterialDialog.Builder(MainActivity.this)
                        .title(R.string.ops)
                        .content(R.string.tenteNovamente)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                finish();
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();

                //Toast.makeText(MainActivity.this, "Ops tenso", Toast.LENGTH_SHORT).show();

            }
        });



    }

}
