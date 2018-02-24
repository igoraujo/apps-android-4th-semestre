package caulculoimc.cotemig.com.br.cauculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.msg)
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
