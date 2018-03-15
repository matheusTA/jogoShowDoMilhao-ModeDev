package view;

import controller.PerguntaController;
import model.Jogador;
import model.Pergunta;;

public class Principal {

    public static void main(String[] args) {

        Jogador jogador = new Jogador("fabio");
        jogador.setPontos(0);
     
       PerguntaController perguntaController = new PerguntaController();
       PerguntaView perguntaView = new PerguntaView();
       
       Pergunta[] perguntas = perguntaController.carregarPerguntas();
       
       for(int i = 0; i < perguntas.length; i++) {
           Pergunta perguntaSelecionada = perguntaController.selecionarPergunta(i, perguntas);
           int repostaPergunta = perguntaView.exibirPergunta(perguntaSelecionada);
           boolean isCorreta = perguntaController.respostaCorreta(perguntaSelecionada, repostaPergunta);
                
           if(isCorreta == true) {
               System.out.println("Sua resposta está correta.");
               int pontos = perguntaSelecionada.gerarPontuacao();
               jogador.adicionarPontos(pontos);
           }else {
               System.out.println("Sua resposta está incorreta.");
               System.out.println("Sua pontuação final é: " + jogador.getPontos());
               System.exit(0);
           }
           
           System.out.println("Sua pontuação é: " + jogador.getPontos());
       }
       
    }

}
