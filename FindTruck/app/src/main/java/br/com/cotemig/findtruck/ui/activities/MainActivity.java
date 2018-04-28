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
                    Toast.makeText(MainActivity.this, "Tudo certo", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Ops", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ops tenso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
