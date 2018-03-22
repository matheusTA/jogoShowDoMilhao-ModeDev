package br.com.novaroma.showDoMilhaoModoDev.apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;
import br.com.novaroma.showDoMilhaoModoDev.entidades.Opcao;
import br.com.novaroma.showDoMilhaoModoDev.entidades.Pergunta;
import br.com.novaroma.showDoMilhaoModoDev.negocio.PerguntaController;

public class TelaPergunta extends JFrame {

    private static int contadorDePerguntas = 0;
    private JPanel contentPane;
    private Pergunta[] perguntas;
    private Pergunta perguntaAtual;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private PerguntaController perguntaController = new PerguntaController();

    private Jogador jogador = new Jogador("Matheus", 0);

    public TelaPergunta() {
        setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 572, 408);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLUE);
        contentPane.setForeground(new Color(255, 255, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nome");
        lblNewLabel.setBounds(371, 11, 133, 25);
        contentPane.add(lblNewLabel);
        lblNewLabel.setText("Nome: " +this.jogador.getNome());
        
        this.lblNewLabel_1 = new JLabel("Pontos");
        this.lblNewLabel_1.setBounds(371, 36, 133, 25);
        contentPane.add(this.lblNewLabel_1);
        this.lblNewLabel_1.setText("Pontuação: " + this.jogador.getPontos());
        
        JLabel lblText = new JLabel();
        lblText.setFont(new Font("Agency FB", Font.BOLD, 24));
        lblText.setForeground(new Color(255, 255, 0));
        lblText.setBounds(20, 91, 526, 61);
        contentPane.add(lblText);

        JLabel lblOpcoes = new JLabel();
        lblOpcoes.setForeground(Color.YELLOW);
        lblOpcoes.setText("<>");
        lblOpcoes.setToolTipText("");
        lblOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
        lblOpcoes.setBounds(20, 163, 526, 113);
        contentPane.add(lblOpcoes);

        textField = new JTextField();
        textField.setBounds(20, 302, 116, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(163, 301, 116, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String resposta = textField.getText();
                boolean resultadoResposta = verificaResposta(resposta);  
                
                if (resultadoResposta == true && isUltimaPergunta()) {
                    exibirPergunta(lblText, lblOpcoes);
                }else {
                    System.exit(0);
                }
                
            };
        });

        iniciarJogo();
        exibirPergunta(lblText, lblOpcoes);
        
      
    }

    private void iniciarJogo() {
        this.perguntas = this.perguntaController.carregarPerguntas();
    }

    private void exibirPergunta(JLabel JLtexto, JLabel JLopcoes) {
        this.perguntaAtual = perguntaController.selecionarPergunta(this.contadorDePerguntas, this.perguntas);

        JLtexto.setText(this.perguntaAtual.getTexto());

        Opcao[] opcoes = this.perguntaAtual.getOpcoes();

        String textoOpcoes = " \n ";
        for (int i = 0; i < opcoes.length; i++) {
            textoOpcoes += " \n [" + i + "] = " + opcoes[i].getTexto() + " \n ";
            JLopcoes.setText(textoOpcoes);
        }

        addContadorPerguntas();
    }

    private boolean verificaResposta(String respostaTexto) {
        int resposta = Integer.parseInt(respostaTexto);

        boolean resultadoDaResposta = perguntaController.respostaCorreta(this.perguntaAtual, resposta);

        if (resultadoDaResposta == true) {
            jogador.adicionarPontos(this.perguntaAtual.gerarPontuacao());
            this.lblNewLabel_1.setText("Pontuação: " + this.jogador.getPontos());
            return true;
        } else {
            return false;

        }

    }
    
    private boolean isUltimaPergunta() {
        return this.perguntaAtual != this.perguntas[this.perguntas.length-1];
    }
    
    private void addContadorPerguntas() {
        this.contadorDePerguntas++;
    }
}
