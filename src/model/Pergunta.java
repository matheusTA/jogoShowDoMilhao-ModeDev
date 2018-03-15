package model;

public class Pergunta {

    private String texto;
    private Opcao[] opcoes;
    private DIFICULDADE dificuldade;

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
    
    
    public DIFICULDADE getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(DIFICULDADE dificuldade) {
        this.dificuldade = dificuldade;
    }

    public boolean selecionarOpcao(int indexOpcao) {
        return this.opcoes[indexOpcao].isCorreto();
    }

    public int gerarPontuacao() {
        if(this.dificuldade == DIFICULDADE.FACIL) {
            return 1000;
        }else if(this.dificuldade == DIFICULDADE.MEDIO) {
            return 10000;
        }else if(this.dificuldade == DIFICULDADE.DIFICIL) {
            return 100000;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String menssagem = this.texto;
        return menssagem;
    }
}
