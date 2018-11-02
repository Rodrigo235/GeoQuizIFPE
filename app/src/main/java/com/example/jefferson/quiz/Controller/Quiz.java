package com.example.jefferson.quiz.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jefferson.quiz.Model.Questao;
import com.example.jefferson.quiz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private Button botaoVerdadeiro;
    private Button botaoFalso;
    private Button botaoTrapacear;
    private ImageButton botaoProximo;
    private ImageButton botaoVoltar;
    private int indiceAtual = 0;
    private int pontuacao = 0;
    private int contador = 0;

    private static final String KEY_POSICAO_ATUAL = "posicao";
    private static final String KEY_PONTUACAO = "pontuacao";
    private static final String KEY_RESPOSTA = "resposta";

    private TextView textoDaQuestao;
    private TextView textoDaPontuacao;

    private List<Questao> questoes = new ArrayList<Questao>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        questoes.add(new Questao(R.string.questao1, false, 3));
        questoes.add(new Questao(R.string.questao2, false, 4));
        questoes.add(new Questao(R.string.questao3, true, 6));
        questoes.add(new Questao(R.string.questao4, true, 8));
        questoes.add(new Questao(R.string.questao5, true, 3));


        super.onCreate(savedInstanceState);

        Log.d(TAG, "método onCrate(): chamado");



        if(savedInstanceState != null) {
            indiceAtual = savedInstanceState.getInt(KEY_POSICAO_ATUAL);
            pontuacao = savedInstanceState.getInt(KEY_PONTUACAO);

        }
        setContentView(R.layout.activity_quiz);
        textoDaPontuacao = (TextView) findViewById(R.id.valor_pontuacao);
        textoDaPontuacao.setText("" + pontuacao);

        //Collections.shuffle(Arrays.asList(conjuntoDeQuestoes));

        textoDaQuestao = (TextView) findViewById(R.id.texto_da_questao);

        textoDaQuestao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarQuestao(1);
            }
        });

        textoDaQuestao.setText(questoes.get(indiceAtual).getIdQuestao());

        botaoVerdadeiro = (Button) findViewById(R.id.respostaverdadeira);
        botaoVerdadeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(true);
            }
        });

        botaoFalso = (Button) findViewById(R.id.respostafalsa);
        botaoFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(false);
            }
        });

        botaoProximo = (ImageButton) findViewById(R.id.botao_proximo);
        botaoProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarQuestao(1);
            }
        });

        botaoVoltar = (ImageButton) findViewById(R.id.botao_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarQuestao(-1);
            }
        });

        botaoTrapacear = (Button) findViewById(R.id.button_trapacear);
        Collections.sort(questoes);

        botaoTrapacear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz.this, TrapacearActivity.class);
                intent.putExtra(TrapacearActivity.getExtraAnswerIsTrue(),questoes.get(indiceAtual).isRespostaQuestao());
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "método onResume(): chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "método onDestroy(): chamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "método onPause(): chamado");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "método onStart(): chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "método onStop(): chamado");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_POSICAO_ATUAL, indiceAtual);
        savedInstanceState.putInt(KEY_PONTUACAO, pontuacao);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void atualizarQuestao(int num) {
        indiceAtual = indiceAtual + num;
        contador++;
        if(contador == questoes.size()) {
            Toast.makeText(Quiz.this, "Pontuacao Final = " + pontuacao, Toast.LENGTH_LONG).show();
            contador = 0;
            pontuacao = 0;
        }
        if(indiceAtual < 0) {
            indiceAtual = questoes.size() - 1;
        } else {
            indiceAtual = indiceAtual % questoes.size();
        }
        int idQuestao = questoes.get(indiceAtual).getIdQuestao();
        textoDaQuestao.setText(idQuestao);
    }

    public void checarResposta (boolean respostaDoUsuario) {
        if(respostaDoUsuario == questoes.get(indiceAtual).isRespostaQuestao()){
            Toast.makeText(Quiz.this,"Acerto Mizeravi toma 50!!", Toast.LENGTH_LONG).show();
            pontuacao = pontuacao + 50;
            textoDaPontuacao = (TextView) findViewById(R.id.valor_pontuacao);
            textoDaPontuacao.setText("" + pontuacao);
            atualizarQuestao(1);
        } else {
            Toast.makeText(Quiz.this, "Errou TROUXÃO perde 100!!", Toast.LENGTH_LONG).show();
            pontuacao = pontuacao - 100;
            textoDaPontuacao = (TextView) findViewById(R.id.valor_pontuacao);
            textoDaPontuacao.setText("" + pontuacao);
            atualizarQuestao(1);
        }
    }

}
