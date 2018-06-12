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

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.txtUserRegister)
    EditText user;

    @BindView(R.id.txtNameRegister)
    EditText name;

    @BindView(R.id.txtLastNameRegister)
    EditText lastname;

    @BindView(R.id.txtPasswordRegister)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegister)
    public void registerClick() {
        register();
    }

    private void register() {
        IServiceUser s = EatApplication.getInstance().getServiceUser();

        final ModelUser modelUser = new ModelUser();
        modelUser.setUser(user.getText().toString());
        modelUser.setName(name.getText().toString());
        modelUser.setLastname(lastname.getText().toString());
        modelUser.setPassword(password.getText().toString());

        Call<ModelUser> call = s.register(modelUser);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                if (response.code() == 204) {
                    Toast.makeText(RegisterActivity.this, "Usuário cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show();

                    new MaterialDialog.Builder(RegisterActivity.this)
                            .title(R.string.ops)
                            .content(R.string.success_register)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    finish();
                                }
                            })
                            .positiveText("Ok")
                            .show();
                } else {
                    errorMessage();
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Falhaaa!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btnBack)
    public void backClick() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void errorMessage() {
        new MaterialDialog.Builder(RegisterActivity.this)
                .title(R.string.ops)
                .content(R.string.generic_register)
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
