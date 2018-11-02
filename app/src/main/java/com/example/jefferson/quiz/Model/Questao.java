package com.example.jefferson.quiz.Model;

import android.support.annotation.NonNull;

import java.util.Objects;

public class Questao implements Comparable <Questao> {

    private int idQuestao;

    private boolean respostaQuestao;

    private int nivelDeDificuldade;

    public Questao(int idQuestao, boolean respostaQuestao, int nivelDeDificuldade){

        this.idQuestao = idQuestao;
        this.respostaQuestao = respostaQuestao;
        this.nivelDeDificuldade = nivelDeDificuldade;

    }


    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public boolean isRespostaQuestao() {
        return respostaQuestao;
    }

    public void setRespostaQuestao(boolean respostaQuestao) {
        this.respostaQuestao = respostaQuestao;
    }

    public int getNivelDeDificuldade() {
        return nivelDeDificuldade;
    }

    public void setNivelDeDificuldade(int nivelDeDificuldade) {
        this.nivelDeDificuldade = nivelDeDificuldade;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "idQuestao=" + idQuestao +
                ", respostaQuestao=" + respostaQuestao +
                ", nivelDeDificuldade=" + nivelDeDificuldade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questao questao = (Questao) o;
        return idQuestao == questao.idQuestao &&
                respostaQuestao == questao.respostaQuestao &&
                nivelDeDificuldade == questao.nivelDeDificuldade;
    }

    @Override
    public int compareTo(@NonNull Questao o) {
        return getNivelDeDificuldade() - o.getNivelDeDificuldade();
    }
}
