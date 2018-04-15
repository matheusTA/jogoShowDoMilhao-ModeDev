package br.com.novaroma.showDoMilhaoModoDev.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import br.com.novaroma.showDoMilhaoModoDev.dados.CSVGravador;
import br.com.novaroma.showDoMilhaoModoDev.dados.CSVLeitor;
import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;

public class JogadorController {
    Jogador jogador;

    public Jogador criarJogador(String nome) {
        this.jogador = new Jogador(nome);
        jogador.setPontos(0);
        return jogador;
    }

    public Jogador[] carregarRecordes() {
        ArrayList<String[]> recordesTexto = CSVLeitor.lerArquivo("Recordes");
        Jogador[] recordes = new Jogador[recordesTexto.size()];
        try {
            for (int i = 0; i < recordesTexto.size(); i++) {

                String[] recordeLinha = recordesTexto.get(i);

                String nome = recordeLinha[0];
                String pontuacao = recordeLinha[1];
                Jogador recorDeJogador = new Jogador(nome, Integer.parseInt(pontuacao));

                recordes[i] = recorDeJogador;

            }
        } catch (Exception e) {
            return null;
        }
        return ordenarJogadoresPorPontos(recordes);
    }

    private Jogador[] ordenarJogadoresPorPontos(Jogador[] jogadoresRecordes) {
        Arrays.sort(jogadoresRecordes, Collections.reverseOrder());
        return jogadoresRecordes;
    }

    public boolean salvarRecorde(Jogador jogador) {
        return CSVGravador.gravarJogadorArquivo("Recordes", jogador);
    }

    

}
