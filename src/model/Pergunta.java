package model;

public class Pergunta {

    private String texto;
    private Opcao[] opcoes;

    public Pergunta() {

    }

    public Pergunta(String texto, Opcao[] opcoes) {

        this.texto = texto;
        this.opcoes = opcoes;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Opcao[] getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(Opcao[] opcoes) {
        this.opcoes = opcoes;
    }

    public void selecionarOpcao() {

    }

    public void gerarPontuacao() {

    }
}
