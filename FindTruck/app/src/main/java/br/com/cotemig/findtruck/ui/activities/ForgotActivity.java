package br.com.cotemig.findtruck.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

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

public class ForgotActivity extends AppCompatActivity {

    @BindView(R.id.user)
    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.forgot)
    public void forgotClick(){
        ServiceUser s = FindTruckApplication.getInstance().getServiceUser();

        ModelUser model = new ModelUser();
        model.setUser(user.getText().toString());

        Call<ModelUser> call = s.forgot(model);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                if(response.code() == 200){
                    Toast.makeText(ForgotActivity.this, "Sucesso! Você receberá uma nova senha por email.", Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(ForgotActivity.this, "Ops!!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                Toast.makeText(ForgotActivity.this, "Ops!!!", Toast.LENGTH_LONG).show();
            }
        });
    }


}
