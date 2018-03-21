package br.com.novaroma.showDoMilhaoModoDev.entidades;

public class Jogador {

    private String nome;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        pontos = 0;
    }
    
    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void adicionarPontos(int novosPontos) {
        this.pontos += novosPontos;
    }

    @Override
    public String toString() {
     String menssagem = "Nome: " + this.nome + "\nPontos: " + this.pontos;
        return menssagem;
    }
}
