package caulculoimc.cotemig.com.br.cauculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtPeso)
    EditText txtPeso;
    @BindView(R.id.txtAltura)
    EditText txtAltura;
    @BindView(R.id.txtMsg)
    TextView txtMsg;
    @BindView(R.id.txtImc)
    TextView txtImc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }
    @OnClick(R.id.btnCalcular)
    public void btnCalcuClick(){
        double p = Double.parseDouble(txtPeso.getText().toString());
        double a = Double.parseDouble(txtAltura.getText().toString());


        double resultado = p / (a * a);

        txtImc.setText(String.format("%.2f", resultado));

        if(resultado < 16){
            txtMsg.setText(getResources().getText(R.string.menor16));
        } else if(resultado < 17){
            txtMsg.setText(getResources().getText(R.string.menor17));
        } else if(resultado < 18.5){
            txtMsg.setText(getResources().getText(R.string.menor185));
        } else if(resultado < 25){
            txtMsg.setText(getResources().getText(R.string.menor25));
        } else if(resultado < 30){
            txtMsg.setText(getResources().getText(R.string.menor30));
        } else if(resultado < 35){
            txtMsg.setText(getResources().getText(R.string.menor35));
        } else if(resultado < 40){
            txtMsg.setText(getResources().getText(R.string.menor40));
        }else
            txtMsg.setText(getResources().getText(R.string.maior40));

    }
}
