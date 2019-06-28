package app.quizorgcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Activity Main, que contem apenas o logo do Quiz, e o botao de iniciar jogo.
 */
public class MainActivity extends AppCompatActivity {

    Button comecarJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando o botao;
        comecarJogo = (Button) findViewById(R.id.bComecarJogo);

        // Listener do botao;
        comecarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestoesActivity();
            }
        });
    }

    /**
     * Metodo que inicializa e abre a activity de questoes.
     */
    public void openQuestoesActivity() {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
}
