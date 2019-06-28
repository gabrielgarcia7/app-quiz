package app.quizorgcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity que explica a questao, caso o usuario erre.
 */
public class ExplicacaoActivity extends AppCompatActivity {

    TextView textoExplicacao;
    Button bContinuar;
    private Questoes mQuestoes = new Questoes();
    int pos;
    int mAcertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacao);

        // Inicializa os objetos;
        textoExplicacao = (TextView) findViewById(R.id.explicacaoText);
        bContinuar = (Button) findViewById(R.id.buttonContinuar);

        // Inicializa o TextView de informacoes, e o torna rolavel;
        textoExplicacao.setMovementMethod(new ScrollingMovementMethod());

        // Obtem as informacoes de questao, e total de acertos da activity de questoes;
        pos = Integer.parseInt(getIntent().getStringExtra("questao"));
        textoExplicacao.setText(mQuestoes.getJustificativa(pos));
        mAcertos = Integer.parseInt(getIntent().getStringExtra("acertos"));

        // Listener para retornar para a tela anterior, ou ir para a tela final;
        bContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pos == 9){
                    openResults();
                }
                else finish();
            }
        });
    }

    /**
     * Metodo que abre a tela final de resultados.
     */
    public void openResults(){
        Intent intent2 = new Intent(this, ResultadoActivity.class);
        intent2.putExtra("info", mAcertos + "");
        startActivity(intent2);
        finish();
    }


}
