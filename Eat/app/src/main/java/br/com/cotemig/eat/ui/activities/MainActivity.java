package br.com.cotemig.eat.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.cotemig.eat.R;
import br.com.cotemig.eat.app.EatApplicarion;
import br.com.cotemig.eat.services.IServiceUser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        IServiceUser s = EatApplicarion.getInstance().getServiceUser();


    }

}
