package br.com.cotemig.findtruck.ui.activities;

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

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.lastname)
    EditText lastName;
    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirmpassword)
    EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.register)
    public void registerClick(){
        ModelUser m = new ModelUser();
        m.setUser(user.getText().toString());
        m.setName(name.getText().toString());
        m.setLastname(lastName.getText().toString());
        m.setPassword(password.getText().toString());

        if(password.getText().toString().equals(confirmPassword.getText().toString())) {

            ServiceUser s = FindTruckApplication.getInstance().getServiceUser();

            Call<ModelUser> call = s.register(m);

            call.enqueue(new Callback<ModelUser>() {
                @Override
                public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                    if (response.code() == 204) {

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
                    errorMessage();
                }
            });

        }else{
            new MaterialDialog.Builder(RegisterActivity.this)
                    .title(R.string.ops)
                    .content(R.string.same_password)
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

    private void errorMessage(){
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
