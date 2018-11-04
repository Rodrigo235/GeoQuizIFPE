package com.example.jefferson.quiz.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.jefferson.quiz.R;

public class TrapacearActivity extends AppCompatActivity {

    private Button mostrarResposta;
    private boolean respotaDaQuestao;
    private TextView txtDaQuestao;
    private static final String EXTRA_ANSWER_SHOWN =  "com.example.jefferson.quiz.verResposta";
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.jefferson.quiz.Model";

    // cria uma um intente (ligação entre atividades) recebendo a atividade que está fazendo ligação a resposta
    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, TrapacearActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapacear);
        txtDaQuestao = (TextView) findViewById(R.id.resposta);
        mostrarResposta = (Button) findViewById(R.id.mostrarResposta);
        respotaDaQuestao = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mostrarResposta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                txtDaQuestao.setText(respotaDaQuestao == true ?
                        R.string.true_button :
                        R.string.false_button);
                // seto que o usuário olhou a resposta, ou seja, trapaceou
                setAnswerShownResult(true);
            }

        });
    }
// método que irá dizer se o usuário trapaceou ou não e guardar no intent (mapa)
    private void setAnswerShownResult(boolean respostaApareceu) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,respostaApareceu);
        setResult(RESULT_OK, data);
    }
// retornar se ele trapaceou ou nao
    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

}
