package br.com.cotemig.findtruck.ui.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import br.com.cotemig.findtruck.R;
import br.com.cotemig.findtruck.app.FindTruckApplication;
import br.com.cotemig.findtruck.model.ModelUser;
import br.com.cotemig.findtruck.services.ServiceUser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.user)
    EditText user;

    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.forgot)
    public void forgotClick(){
        Intent i = new Intent(this, ForgotActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.register)
    public void registerClick(){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.login)
    public void loginClick(){
        auth();
    }

    private void auth(){
        ServiceUser s = FindTruckApplication.getInstance().getServiceUser();

        ModelUser m = new ModelUser();
        m.setUser(user.getText().toString());
        m.setPassword(password.getText().toString());

        Call<ModelUser> call = s.auth(m);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                if(response.code() == 200){

                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);

                }else{
                    new MaterialDialog.Builder(MainActivity.this)
                            .title(R.string.ops)
                            .content(R.string.message_invalid_user)
                            .positiveText(R.string.ok)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                errorMessage();
            }
        });
    }

    private void errorMessage(){
        new MaterialDialog.Builder(MainActivity.this)
                .title(R.string.ops)
                .content(R.string.generic_login)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        finish();
                    }
                })
                .positiveText(R.string.ok)
                .show();
    }
}
