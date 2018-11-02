package com.example.jefferson.quiz.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.jefferson.quiz.Model.Questao;
import com.example.jefferson.quiz.R;

public class TrapacearActivity extends AppCompatActivity {

    private Button mostrarResposta;
    private boolean respotaDaQuestao;
    private TextView txtDaQuestao;

    private Questao questao;
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
                txtDaQuestao.setText("" + respotaDaQuestao);
            }

        });
    }
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.jefferson.quiz.Model";

    public static String getExtraAnswerIsTrue(){
        return EXTRA_ANSWER_IS_TRUE;
    }


}
