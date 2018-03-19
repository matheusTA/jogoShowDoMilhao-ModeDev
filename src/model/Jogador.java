package model;

public class Jogador {

    private String nome;
    private int pontos;

    public Jogador() {

    }

    public Jogador(String nome) {
        this.nome = nome;
        pontos = 0;
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
