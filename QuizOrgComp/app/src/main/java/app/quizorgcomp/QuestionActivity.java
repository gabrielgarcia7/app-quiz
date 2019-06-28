package app.quizorgcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Activity principal do quiz, que mostra as questoes e
 * quatro alternativas;
 */
public class QuestionActivity extends AppCompatActivity {

    private Button resposta1, resposta2, resposta3, resposta4;
    private TextView totalAcertos, questao;
    private Questoes mQuestoes = new Questoes();
    private String mResposta;
    private int mAcertos = 0;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Inicializando os botoes e os textViews das questoes;
        resposta1 = (Button) findViewById(R.id.resposta1);
        resposta2 = (Button) findViewById(R.id.resposta2);
        resposta3 = (Button) findViewById(R.id.resposta3);
        resposta4 = (Button) findViewById(R.id.resposta4);
        totalAcertos = (TextView) findViewById(R.id.totalAcertos);
        questao = (TextView) findViewById(R.id.questao);

        // Inicializa o TextView de informacoes, e o torna rolavel;
        questao.setMovementMethod(new ScrollingMovementMethod());

        // Atualiza a questao, e o total de acertos;
        totalAcertos.setText("Acertos: " + mAcertos);
        atualizaQuestao();

        // Listener da resposta 1;
        resposta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(resposta1.getText() == mResposta){
                    respostaCorreta();
                    if(pos == 9) finish();
                }
                else{
                    explicaQuestao();
                    if(pos == 9) finish();
                }

                Timer buttonTimer = new Timer();
                buttonTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                totalAcertos.setText("Acertos: " + mAcertos);
                                pos++;
                                if(pos < 10) atualizaQuestao();
                            }
                        });
                    }
                }, 600);
            }

        });

        // Listener da resposta 2;
        resposta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(resposta2.getText() == mResposta){
                    respostaCorreta();
                    if(pos == 9) finish();
                }
                else{
                    explicaQuestao();
                    if(pos == 9) finish();
                }

                Timer buttonTimer = new Timer();
                buttonTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                totalAcertos.setText("Acertos: " + mAcertos);
                                pos++;
                                if(pos < 10) atualizaQuestao();
                            }
                        });
                    }
                }, 600);

            }
        });

        // Listener da resposta 3;
        resposta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(resposta3.getText() == mResposta){
                    respostaCorreta();
                    if(pos == 9) finish();
                }
                else{
                    explicaQuestao();
                    if(pos == 9) finish();
                }

                Timer buttonTimer = new Timer();
                buttonTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                totalAcertos.setText("Acertos: " + mAcertos);
                                pos++;
                                if(pos < 10) atualizaQuestao();
                            }
                        });
                    }
                }, 600);

            }
        });

        // Listener da resposta 4;
        resposta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(resposta4.getText() == mResposta){
                    respostaCorreta();
                    if(pos == 9) finish();

                }
                else{
                    explicaQuestao();
                    if(pos == 9) finish();
                }

                Timer buttonTimer = new Timer();
                buttonTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                totalAcertos.setText("Acertos: " + mAcertos);
                                pos++;
                                if(pos < 10) atualizaQuestao();
                            }
                        });
                    }
                }, 600);

            }
        });

    }

    /**
     * Metodo que atualiza a questao, mostrando a proxima, apos o usuario responder.
     */
    private void atualizaQuestao(){
        questao.setText(mQuestoes.getQuestao(pos));
        resposta1.setText(mQuestoes.getResposta1(pos));
        resposta2.setText(mQuestoes.getResposta2(pos));
        resposta3.setText(mQuestoes.getResposta3(pos));
        resposta4.setText(mQuestoes.getResposta4(pos));
        mResposta = mQuestoes.getRespostaCorreta(pos);
    }

    /**
     * Metodo que abre a activity Explicacao, caso o usuario tenha errado a questao.
     */
    private void explicaQuestao(){

        Intent intent = new Intent(this, ExplicacaoActivity.class);
        intent.putExtra("questao", pos + "");
        intent.putExtra("acertos", mAcertos+"");
        startActivity(intent);
    }

    /**
     * Metodo que abre a activity QuestaoCorreta, caso o usuario tenha acertado a questao.
     */
    private void respostaCorreta(){

        mAcertos++;

        Intent intent = new Intent(this, QuestaoCorretaActivity.class);
        intent.putExtra("questao", pos + "");
        intent.putExtra("acertos", mAcertos+"");
        startActivity(intent);
    }

}
