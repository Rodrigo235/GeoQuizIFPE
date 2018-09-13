package com.example.jefferson.quiz.Model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jefferson.quiz.R;

public class TrapacearActivity extends AppCompatActivity {

    private Button mostrarResposta;
    private String respotaDaQuestao;
    private Questao questao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapacear);
        mostrarResposta = (Button) findViewById(R.id.mostrarResposta);
        Intent intent = getIntent();
        respotaDaQuestao = "" + intent.getBooleanArrayExtra(getExtraAnswerIsTrue());
        System.out.print(intent.getBooleanArrayExtra(EXTRA_ANSWER_IS_TRUE));

        mostrarResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TrapacearActivity.this,respotaDaQuestao, Toast.LENGTH_LONG).show();
            }
        });
    }
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.jefferson.quiz.Model";

    public static String getExtraAnswerIsTrue(){
        return EXTRA_ANSWER_IS_TRUE;
    }


}
