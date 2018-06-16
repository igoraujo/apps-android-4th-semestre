package br.com.cotemig.eat.ui.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import br.com.cotemig.eat.R;
import br.com.cotemig.eat.app.EatApplication;
import br.com.cotemig.eat.models.ModelUser;
import br.com.cotemig.eat.services.IServiceUser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

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

    @OnClick(R.id.login)
    public void loginClick() {
        auth();
    }

    @OnClick(R.id.forgot)
    public void forgotClick() {
        Intent intent = new Intent(this, ForgotActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.register)
    public void registerClick() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    private void auth() {
        IServiceUser s = EatApplication.getInstance().getServiceUser();

        final ModelUser modelUser = new ModelUser();
        modelUser.setUser(user.getText().toString());
        modelUser.setPassword(password.getText().toString());
//        modelUser.setUser("igor@araujo.work");
//        modelUser.setPassword("senha123456");

        Call<ModelUser> call = s.auth(modelUser);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {

                if (response.code() == 200) {

                    new MaterialDialog.Builder(LoginActivity.this)
                            .title(R.string.ops)
                            .content(R.string.error)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    finish();
                                }
                            }).show();

                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);

                } else {
                    new MaterialDialog.Builder(LoginActivity.this)
                            .title(R.string.ops)
                            .content(R.string.error)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    finish();
                                }
                            })
                            .positiveText("Ok")
                            .show();
                }

            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                new MaterialDialog.Builder(LoginActivity.this)
                        .title(R.string.ops)
                        .content(R.string.error)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                finish();
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
            }
        });

    }

}
