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

public class NovaContaActivity extends AppCompatActivity {

    @BindView(R.id.editNome)
    EditText editNome;
    @BindView(R.id.editSobrenome)
    EditText editSobrenome;
    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.editSenha)
    EditText editSenha;


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


    private void register(){

        ServiceUser s = FoodComillancaApplication.getInstance().getServiceUser();

        ModelUser m = new ModelUser();
        m.setUser(editNome.getText().toString());
        m.setUser(editSobrenome.getText().toString());
        m.setUser(editEmail.getText().toString());
        m.setUser(editSenha.getText().toString());

        retrofit2.Call<ModelUser> call = s.auth(m);

        call.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(retrofit2.Call<ModelUser> call, Response<ModelUser> response) {
                if(response.code() == 200){
                    Toast.makeText(NovaContaActivity.this, "Tudo certo", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(NovaContaActivity.this, "Ops", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ModelUser> call, Throwable t) {
                Toast.makeText(NovaContaActivity.this, "Ops tenso", Toast.LENGTH_SHORT).show();

            }
        });



    }


}
