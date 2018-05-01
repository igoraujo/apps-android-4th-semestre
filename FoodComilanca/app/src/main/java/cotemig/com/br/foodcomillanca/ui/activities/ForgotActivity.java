package cotemig.com.br.foodcomillanca.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cotemig.com.br.foodcomillanca.R;
import cotemig.com.br.foodcomillanca.app.FoodComillancaApplication;
import cotemig.com.br.foodcomillanca.model.ModelUser;
import cotemig.com.br.foodcomillanca.service.ServiceUser;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotActivity extends AppCompatActivity {

    @BindView(R.id.editEmailUsuario)
    EditText editEmailUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        ButterKnife.bind(this);


    }


    @OnClick(R.id.btnNovasenha)
    public void loginClick(){
        forgot();
    }




    private void forgot(){

        ServiceUser s = FoodComillancaApplication.getInstance().getServiceUser();

        ModelUser m = new ModelUser();
        m.setUser(editEmailUsuario.getText().toString());

        retrofit2.Call<ModelUser> call = s.auth(m);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(retrofit2.Call<ModelUser> call, Response<ModelUser> response) {
                if(response.code() == 200){
                    Toast.makeText(ForgotActivity.this, "Tudo certo", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ForgotActivity.this, "Ops", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ModelUser> call, Throwable t) {
                Toast.makeText(ForgotActivity.this, "Ops tenso", Toast.LENGTH_SHORT).show();

            }
        });







    }





}
