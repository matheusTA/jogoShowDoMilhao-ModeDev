package br.com.novaroma.showDoMilhaoModoDev.negocio;

import java.util.ArrayList;

import br.com.novaroma.showDoMilhaoModoDev.dados.CSVLeitor;
import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;

public class JogadorController {

    public Jogador criarJogador(String nome) {
        Jogador jogador = new Jogador(nome);
        jogador.setPontos(0);
        return jogador;
    }

    public Jogador[] carregarRecordes() {
        ArrayList<String[]> recordesTexto = CSVLeitor.lerArquivo("Recordes");
        Jogador[] recordes = new Jogador[recordesTexto.size()];

        for (int i = 0; i < recordesTexto.size(); i++) {

            String[] recordeLinha = recordesTexto.get(i);

            String nome = recordeLinha[0];
            String pontuacao = recordeLinha[1];
            Jogador recorDeJogador = new Jogador(nome, Integer.parseInt(pontuacao));

            recordes[i] = recorDeJogador;

        }
        return recordes;
    }
}
