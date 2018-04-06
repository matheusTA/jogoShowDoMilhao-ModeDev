package br.com.novaroma.showDoMilhaoModoDev.dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVLeitor {
    
    
    public static  ArrayList<String[]> lerArquivo(String nomeDoArquivo) {
        String csvFile = nomeDoArquivo + ".csv";
        String line = "";
        String cvsSplitBy = ";";
        ArrayList<String[]> linhasTotais = new ArrayList<String[]>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] linha = line.split(cvsSplitBy);
                linhasTotais.add(linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhasTotais;
    }

}