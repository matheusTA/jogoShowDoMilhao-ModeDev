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
import javax.swing.border.EmptyBorder;

import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;
import br.com.novaroma.showDoMilhaoModoDev.negocio.JogadorController;

public class TelaJogador extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private Jogador jogadorCriado;
    private JLabel lblQualOSeu;

  
    /**
     * Create the frame.
     */
    public TelaJogador() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 443);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 235, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        
        
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnConfirmar.setForeground(new Color(0, 0, 0));
        btnConfirmar.setBackground(Color.LIGHT_GRAY);
        btnConfirmar.setBounds(388, 225, 117, 32);
        contentPane.add(btnConfirmar);
        
        textField = new JTextField();
        textField.setFont(new Font("Agency FB", Font.PLAIN, 23));
        textField.setBackground(new Color(204, 204, 204));
        textField.setBounds(312, 173, 268, 32);
        contentPane.add(textField);
        textField.setColumns(10);
        
        lblQualOSeu = new JLabel("Qual o seu nome:");
        lblQualOSeu.setBackground(new Color(0, 0, 0));
        lblQualOSeu.setForeground(new Color(0, 0, 0));
        lblQualOSeu.setFont(new Font("Agency FB", Font.PLAIN, 24));
        lblQualOSeu.setBounds(312, 135, 180, 27);
        contentPane.add(lblQualOSeu);
        
        btnConfirmar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                JogadorController jogadorController = new JogadorController();
                jogadorCriado = jogadorController.criarJogador(textField.getText());
                trocarTelaPergunta(jogadorCriado);
                
            }
        });
          
    }
    
    private void trocarTelaPergunta(Jogador jogadorCriado) {
        this.setVisible(false);
        TelaPergunta telaPergunta = new TelaPergunta(jogadorCriado);
        telaPergunta.show();
    }
    
}
