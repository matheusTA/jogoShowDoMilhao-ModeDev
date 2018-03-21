package br.com.novaroma.showDoMilhaoModoDev.negocio;

import java.util.ArrayList;

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
           
           Opcao[] opcoes = {opcaoA, opcaoB, opcaoC, opcaoD};
           
           String dificuldade = perguntaLinha[9];
           Pergunta pergunta = null;
           
           if(dificuldade.equals("FACIL")) {
                pergunta = new Pergunta(texto, opcoes, DIFICULDADE.FACIL);
           }else if(dificuldade.equals("MEDIO")) {
                pergunta = new Pergunta(texto, opcoes, DIFICULDADE.MEDIO);
           }else if(dificuldade.equals("DIFICIL")) {
                pergunta = new Pergunta(texto, opcoes, DIFICULDADE.DIFICIL);
           }
           
           perguntas[i] = pergunta;
           
        }
        
        return perguntas;
    }
    

    
    
}
