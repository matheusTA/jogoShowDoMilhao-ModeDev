package br.com.novaroma.showDoMilhaoModoDev.entidades;

import br.com.novaroma.showDoMilhaoModoDev.utils.DIFICULDADE;

public class Pergunta {

    private String texto;
    private Opcao[] opcoes;
    private DIFICULDADE dificuldade;

    public Pergunta(String texto, Opcao[] opcoes, DIFICULDADE dificuldade) {
        this.texto = texto;
        this.opcoes = opcoes;
        this.dificuldade = dificuldade;
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
            return 25000;
        }else if(this.dificuldade == DIFICULDADE.MEDIO) {
            return 100000;
        }else if(this.dificuldade == DIFICULDADE.DIFICIL) {
            return 250000;
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
