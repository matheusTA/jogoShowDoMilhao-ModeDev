package controller;

import model.Opcao;
import model.Pergunta;
import utils.DIFICULDADE;

public class PerguntaController {

    public Pergunta selecionarPergunta(int index, Pergunta[] perguntas) {
        return perguntas[index];
    }
    
    public boolean respostaCorreta(Pergunta pergunta, int index) {
        return pergunta.getOpcoes()[index].isCorreto();
    }
    
    public Pergunta[] carregarPerguntas() {
        Pergunta pergunta = new Pergunta();
        pergunta.setDificuldade(DIFICULDADE.FACIL);
        
        pergunta.setTexto("Qual o tamanho em bits para a variavel char?");
        Opcao opcao01 = new Opcao("1", false);
        Opcao opcao02 = new Opcao("8", false);
        Opcao opcao03 = new Opcao("16", true);
        Opcao opcao04 = new Opcao("38", false);
        Opcao opcao05 = new Opcao("64", false);

        Opcao[] opcoes = { opcao01, opcao02, opcao03, opcao04, opcao05 };
        pergunta.setOpcoes(opcoes);

       Pergunta[] perguntasFacies = {pergunta, pergunta, pergunta, pergunta, pergunta};
       return perguntasFacies;
    }
    
}
