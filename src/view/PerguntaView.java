package view;

import javax.swing.JOptionPane;

import model.Pergunta;

public class PerguntaView {

    public int exibirPergunta(Pergunta pergunta) {
        String menssagem = pergunta.getTexto() + "\n";
        for(int i = 0; i < pergunta.getOpcoes().length; i++) {
            menssagem = menssagem + i + " - " + pergunta.getOpcoes()[i] + "\n";
        }
        int resposta = Integer.parseInt(JOptionPane.showInputDialog(menssagem));     
        return resposta;
    }
}
