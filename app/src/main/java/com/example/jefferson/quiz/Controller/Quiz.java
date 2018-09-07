package com.example.jefferson.quiz.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AutoText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jefferson.quiz.Model.Questao;
import com.example.jefferson.quiz.Model.TrapacearActivity;
import com.example.jefferson.quiz.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Quiz extends AppCompatActivity {

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

    private TextView textoDaQuestao;
    private TextView textoDaPontuacao;

    private Questao[] conjuntoDeQuestoes = new Questao[] {
            new Questao(R.string.questao1, false),
            new Questao(R.string.questao2, false),
            new Questao(R.string.questao3, true),
            new Questao(R.string.questao4, true),
            new Questao(R.string.questao5, true)
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            indiceAtual = savedInstanceState.getInt(KEY_POSICAO_ATUAL);
            pontuacao = savedInstanceState.getInt(KEY_PONTUACAO);
        }
        textoDaPontuacao = (TextView) findViewById(R.id.valor_pontuacao);
        textoDaPontuacao.setText("" + pontuacao);
        setContentView(R.layout.activity_quiz);



        //Collections.shuffle(Arrays.asList(conjuntoDeQuestoes));

        textoDaQuestao = (TextView) findViewById(R.id.texto_da_questao);

        textoDaQuestao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarQuestao(1);
            }
        });

        textoDaQuestao.setText(conjuntoDeQuestoes[indiceAtual].getIdQuestao());

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

        botaoTrapacear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz.this, TrapacearActivity.class);
                intent.putExtra(TrapacearActivity.getExtraAnswerIsTrue(),conjuntoDeQuestoes[indiceAtual].isRespostaQuestao());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_POSICAO_ATUAL, indiceAtual);
        savedInstanceState.putInt(KEY_PONTUACAO, pontuacao);
    }

    public void atualizarQuestao(int num) {
        indiceAtual = indiceAtual + num;
        contador++;
        if(contador == conjuntoDeQuestoes.length) {
            Toast.makeText(Quiz.this, "Pontuacao Final = " + pontuacao, Toast.LENGTH_LONG).show();
            contador = 0;
        }
        if(indiceAtual < 0) {
            indiceAtual = conjuntoDeQuestoes.length - 1;
        } else {
            indiceAtual = indiceAtual % conjuntoDeQuestoes.length;
        }
        int idQuestao = conjuntoDeQuestoes[indiceAtual].getIdQuestao();
        textoDaQuestao.setText(idQuestao);
    }

    public void checarResposta (boolean respostaDoUsuario) {
        if(respostaDoUsuario == conjuntoDeQuestoes[indiceAtual].isRespostaQuestao()){
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
