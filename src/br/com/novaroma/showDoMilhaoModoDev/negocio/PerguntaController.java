package br.com.novaroma.showDoMilhaoModoDev.negocio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import br.com.novaroma.showDoMilhaoModoDev.dados.CSVLeitor;
import br.com.novaroma.showDoMilhaoModoDev.entidades.Opcao;
import br.com.novaroma.showDoMilhaoModoDev.entidades.Pergunta;
import br.com.novaroma.showDoMilhaoModoDev.utils.DIFICULDADE;

public class PerguntaController {

    public Pergunta selecionarPergunta(int index, Pergunta[] perguntas) {
        return perguntas[index];
    }

    public boolean respostaCorreta(Pergunta pergunta, int index) {
        return pergunta.getOpcoes()[index].isCorreto();
    }

    public Pergunta[] carregarPerguntas() {

        ArrayList<String[]> perguntasTexto = CSVLeitor.lerArquivo("Perguntas");
        Pergunta[] perguntas = new Pergunta[perguntasTexto.size()];

        for (int i = 0; i < perguntasTexto.size(); i++) {

            String[] perguntaLinha = perguntasTexto.get(i);
            String texto = perguntaLinha[0];

            String textoPerguntaA = perguntaLinha[1];
            String respostaA = perguntaLinha[2];
            Opcao opcaoA = new Opcao(textoPerguntaA, Boolean.parseBoolean(respostaA));

            String textoPerguntaB = perguntaLinha[3];
            String respostaB = perguntaLinha[4];
            Opcao opcaoB = new Opcao(textoPerguntaB, Boolean.parseBoolean(respostaB));

            String textoPerguntaC = perguntaLinha[5];
            String respostaC = perguntaLinha[6];
            Opcao opcaoC = new Opcao(textoPerguntaC, Boolean.parseBoolean(respostaC));

            String textoPerguntaD = perguntaLinha[7];
            String respostaD = perguntaLinha[8];
            Opcao opcaoD = new Opcao(textoPerguntaD, Boolean.parseBoolean(respostaD));

            Opcao[] opcoes = { opcaoA, opcaoB, opcaoC, opcaoD };

            String dificuldade = perguntaLinha[9];
            Pergunta pergunta = null;

            if (dificuldade.equals("FACIL")) {
                pergunta = new Pergunta(texto, opcoes, DIFICULDADE.FACIL);
            } else if (dificuldade.equals("MEDIO")) {
                pergunta = new Pergunta(texto, opcoes, DIFICULDADE.MEDIO);
            } else if (dificuldade.equals("DIFICIL")) {
                pergunta = new Pergunta(texto, opcoes, DIFICULDADE.DIFICIL);
            }

            perguntas[i] = pergunta;

        }

        return perguntas;
    }

    public boolean validaOpcao(String resposta) {
        int respostaInt = Integer.parseInt(resposta);

        if (respostaInt >= 0 && respostaInt <= 3) {
            return true;
        } else {
            return false;
        }
    }

    public Pergunta removeDuasOpcoesIncorretas(Pergunta perguntaAtual) {

        ArrayList<Opcao> listaOpcoes = new ArrayList<Opcao>(Arrays.asList(perguntaAtual.getOpcoes()));

        for (int i = 0; i < listaOpcoes.size(); i++) {

            if (listaOpcoes.get(i).isCorreto() == false) {
                listaOpcoes.remove(i);
            }

        }

        Opcao[] novasOpcoes = new Opcao[listaOpcoes.size()];
        novasOpcoes = listaOpcoes.toArray(novasOpcoes);
        perguntaAtual.setOpcoes(novasOpcoes);
        return perguntaAtual;

    }

}
