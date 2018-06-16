package cotemig.com.br.foodcomillanca.ui.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cotemig.com.br.foodcomillanca.R;
import cotemig.com.br.foodcomillanca.app.FoodComillancaApplication;
import cotemig.com.br.foodcomillanca.model.ModelUser;
import cotemig.com.br.foodcomillanca.service.ServiceUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NovaContaActivity extends AppCompatActivity {

    @BindView(R.id.editNome)
    EditText editNome;
    @BindView(R.id.editSobrenome)
    EditText editSobrenome;
    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.editSenha)
    EditText editSenha;
    @BindView(R.id.confirmpassword)
    EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.btnCadastrar)
    public void novasenhaClick(){
        register();
    }


    private void register() {
        ModelUser m = new ModelUser();
        m.setName(editNome.getText().toString());
        m.setLastname(editSobrenome.getText().toString());
        m.setUser(editEmail.getText().toString());
        m.setPassword(editSenha.getText().toString());




        if (editSenha.getText().toString().equals(confirmPassword.getText().toString())) {


            ServiceUser s = FoodComillancaApplication.getInstance().getServiceUser();

            Call<ModelUser> call = s.register(m);

            call.enqueue(new Callback<ModelUser>() {
                @Override
                public void onResponse(retrofit2.Call<ModelUser> call, Response<ModelUser> response) {
                    if (response.code() == 204) {

                        new MaterialDialog.Builder(NovaContaActivity.this)
                                .title(R.string.success)
                                .content(R.string.success)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        finish();
                                    }
                                })
                                .positiveText(R.string.ok)
                                .show();

                    } else {
                        errorMessage();
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<ModelUser> call, Throwable t) {
                    new MaterialDialog.Builder(NovaContaActivity.this)
                            .title(R.string.ops)
                            .content(R.string.same_password)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                }
                            })
                            .positiveText(R.string.ok)
                            .show();
                }
            });


        }
    }


    private void errorMessage() {
        new MaterialDialog.Builder(NovaContaActivity.this)
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
