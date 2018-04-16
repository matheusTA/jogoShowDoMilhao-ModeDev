package br.com.novaroma.showDoMilhaoModoDev.dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;
import br.com.novaroma.showDoMilhaoModoDev.negocio.JogadorController;

public class CSVGravador {

    public static boolean gravarJogadorArquivo(String nomeDoArquivo, Jogador jogador) {
        String csvFile = nomeDoArquivo + ".csv";
        String cvsSplitBy = ";";
        ArrayList<Jogador> recordesNovoJogador;
        JogadorController jogadorControler = new JogadorController();
        Jogador[] carregarRecordes = jogadorControler.carregarRecordes();

        try {
            recordesNovoJogador = new ArrayList<Jogador>(Arrays.asList(carregarRecordes));
        } catch (Exception e) {
            recordesNovoJogador = new ArrayList<Jogador>();
        }

        recordesNovoJogador.add(jogador);
        PrintWriter pw;

        try {
            pw = new PrintWriter(new File(csvFile));
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < recordesNovoJogador.size(); i++) {

                stringBuilder.append(recordesNovoJogador.get(i).getNome());
                stringBuilder.append(cvsSplitBy);
                stringBuilder.append(recordesNovoJogador.get(i).getPontos());
                stringBuilder.append(cvsSplitBy);
                stringBuilder.append('\n');
            }

            pw.write(stringBuilder.toString());
            pw.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean limpaArquivoReCordes() {
        String csvFile = "Recordes.csv";
        PrintWriter pw;

        try {
            pw = new PrintWriter(new File(csvFile));
            pw.write("");
            pw.close();
            return true;
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
