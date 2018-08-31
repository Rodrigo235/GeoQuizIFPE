package com.example.jefferson.quiz.Model;

public class Questao {

    private int idQuestao;

    private boolean respostaQuestao;


    public Questao(int idQuestao, boolean respostaQuestao){

        this.idQuestao = idQuestao;
        this.respostaQuestao = respostaQuestao;

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
}
