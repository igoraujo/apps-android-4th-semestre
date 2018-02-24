package br.com.cotemig.aula01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtResultado)
    TextView txtResultado;

    @BindView(R.id.btn00)
    Button btn00;

    @BindView(R.id.btn01)
    Button btn01;

    @BindView(R.id.btn02)
    Button btn02;

    @BindView(R.id.btn03)
    Button btn03;

    @BindView(R.id.btn04)
    Button btn04;

    @BindView(R.id.btn05)
    Button btn05;

    @BindView(R.id.btn06)
    Button btn06;

    @BindView(R.id.btn07)
    Button btn07;

    @BindView(R.id.btn08)
    Button btn08;

    @BindView(R.id.btn09)
    Button btn09;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnIgual = findViewById(R.id.btnIgual);
//        btn01 = findViewById(R.id.btn01);
//
//        btn01.setOnClickListener(this);
    }

   @OnClick(R.id.btn00)
    public  void btn00Click(){
        txtResultado.setText('0');
    }

//    public void onClick(View v) {
//
//        switch(v.getId()) {
//            case 0:
//                btnIgual.setText("0");
//                break;
//            case 1:
//
//                break;
//            default:
//
//        }
//
//    }
}
