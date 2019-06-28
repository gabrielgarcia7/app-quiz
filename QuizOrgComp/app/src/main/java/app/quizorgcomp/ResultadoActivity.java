package app.quizorgcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView totalAcertos, statusFinal;
    Button voltarMain;

    private Questoes mQuestoes = new Questoes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        totalAcertos = (TextView) findViewById(R.id.acertosFinal);
        statusFinal = (TextView) findViewById(R.id.textStatusFinal);
        voltarMain = (Button) findViewById(R.id.bVoltarMain);

        int acertos = Integer.parseInt(getIntent().getStringExtra("info"));
        String s = "Total de acertos: " + acertos;

        totalAcertos.setText(s);
        statusFinal.setText(mQuestoes.getStatusFinal(acertos));


        voltarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

    }

    private void openMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
