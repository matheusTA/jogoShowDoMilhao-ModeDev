package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PerguntaController;
import model.Jogador;
import model.Pergunta;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaPergunta extends JFrame {

    private static int contadorDePerguntas = 0;
    private JPanel contentPane;
    private Pergunta[] perguntas;
    private Jogador jogador = new Jogador("Matheus", 0);
    private JTextField textField;

    public TelaPergunta( ) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblText = new JLabel("Qual o tamanho em bits para a váriavel do tipo short?");
        lblText.setBounds(20, 11, 388, 61);
        contentPane.add(lblText);
        
        JLabel lblOpcoes = new JLabel("opcoes");
        lblOpcoes.setBounds(20, 83, 372, 113);
        contentPane.add(lblOpcoes);
        
        textField = new JTextField();
        textField.setBounds(94, 208, 116, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(235, 207, 89, 23);
        contentPane.add(btnNewButton);
        
        inciarPerguntas();
        iniciarJogo(lblText, lblOpcoes, btnNewButton);
    }

    private void inciarPerguntas() {
        PerguntaController perguntaController = new PerguntaController();
        this.perguntas = perguntaController.carregarPerguntas();
    }

    private void iniciarJogo(JLabel texto, JLabel opcoes, JButton buttao) {
        PerguntaController perguntaController = new PerguntaController();
        Pergunta perguntaAtual = perguntaController.selecionarPergunta(this.contadorDePerguntas, this.perguntas);
        
        texto.setText(perguntaAtual.getTexto());
        
        buttao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                addContadorPerguntas();
                iniciarJogo(texto, opcoes, buttao);
             };
        });
        
        
    }
    
    private void addContadorPerguntas() {
        this.contadorDePerguntas++;
    }
    
    
   
}
