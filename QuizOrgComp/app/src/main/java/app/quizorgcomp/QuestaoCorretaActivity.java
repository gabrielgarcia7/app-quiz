package app.quizorgcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Activity que informa ao usuario que ele acertou a questao, caso acerte.
 */
public class QuestaoCorretaActivity extends AppCompatActivity {

    Button continuar;
    int pos, mAcertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao_correta);

        // Inicializando o botao;
        continuar = (Button) findViewById(R.id.continuarJogoB);

        // Obtem as informacoes de questao, e total de acertos da activity de questoes;
        pos = Integer.parseInt(getIntent().getStringExtra("questao"));
        mAcertos = Integer.parseInt(getIntent().getStringExtra("acertos"));

        // Listener para retornar para a tela anterior, ou ir para a tela final;
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos == 9)
                    openResults();
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
