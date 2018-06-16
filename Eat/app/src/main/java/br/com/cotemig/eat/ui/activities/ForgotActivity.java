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

public class ForgotActivity extends AppCompatActivity {

    @BindView(R.id.txtUserForgot)
    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRecover)
    public void recoverClick() {
        recover();
    }

    private void recover() {
        IServiceUser s = EatApplication.getInstance().getServiceUser();

        final ModelUser modelUser = new ModelUser();
        modelUser.setUser(user.getText().toString());

        Call<ModelUser> call = s.forgot(modelUser);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                if (response.code() == 200) {
                    if (response.body().getUser().toString().equals(user.getText().toString())) {
                        Toast.makeText(ForgotActivity.this, "Um e-mail foi enviado para: " + response.body().getUser(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ForgotActivity.this, "E-mail não encontrado!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ForgotActivity.this, "Ops! Algo de errado aconteceu. HTTPResponse: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                Toast.makeText(ForgotActivity.this, "Falhaaa!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick(R.id.btnBack)
    public void backClick() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
