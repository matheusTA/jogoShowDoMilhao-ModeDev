package controller;

import model.Jogador;

public class JogadorController {

    public Jogador criarJogador(String nome) {
        Jogador jogador = new Jogador(nome);
        jogador.setPontos(0);
        return jogador;
    }
}
