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
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 153, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnConfirmar.setForeground(new Color(0, 0, 0));
        btnConfirmar.setBackground(new Color(0, 0, 0));
        btnConfirmar.setBounds(307, 218, 117, 32);
        contentPane.add(btnConfirmar);
        
        textField = new JTextField();
        textField.setFont(new Font("Agency FB", Font.PLAIN, 23));
        textField.setBackground(new Color(204, 204, 204));
        textField.setBounds(10, 91, 268, 32);
        contentPane.add(textField);
        textField.setColumns(10);
        
        lblQualOSeu = new JLabel("Qual o seu nome:");
        lblQualOSeu.setBackground(new Color(0, 0, 0));
        lblQualOSeu.setForeground(new Color(0, 0, 0));
        lblQualOSeu.setFont(new Font("Agency FB", Font.PLAIN, 24));
        lblQualOSeu.setBounds(10, 45, 180, 27);
        contentPane.add(lblQualOSeu);
        
        btnConfirmar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                JogadorController jogadorController = new JogadorController();
                jogadorCriado = jogadorController.criarJogador(textField.getText());
                System.out.println("Jogador criado:\n" + jogadorCriado);
                fecharTela();
            }
        });
          
    }
    
    private void fecharTela() {
        this.setVisible(false);
    }
   
}
