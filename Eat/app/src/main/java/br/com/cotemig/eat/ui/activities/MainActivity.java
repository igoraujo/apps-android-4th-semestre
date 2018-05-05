package br.com.cotemig.eat.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

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

        Call<ModelUser> call = s.auth(modelUser);


        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {

                if (response.code() == 200) {
                    if (response.body().getUser().toString().equals(user.getText().toString()) && response.body().getPassword().toString().equals(password.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Entrou", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Login ou senha incorreto.", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Ops! Algo de errado aconteceu. HTTPResponse: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falhaaa!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
