package br.com.novaroma.showDoMilhaoModoDev.apresentacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();

                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaPrincipal() {     
        initialize();
        this.frame.setLocationRelativeTo(null);
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBackground(new Color(250, 235, 215));
        frame.getContentPane().setBackground(new Color(250, 235, 215));
        frame.setBounds(100, 100, 909, 433);

        frame.getContentPane().setLayout(null);

        JButton btnJogar = new JButton("Jogar");
        btnJogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                trocarTelaCriarJogador();
            };
        });
        btnJogar.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnJogar.setBounds(397, 166, 98, 37);
        frame.getContentPane().add(btnJogar);

        JButton btnNewButton = new JButton("Recorde");
        btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               trocarTelaRecorde();
                
            };
        });
        btnNewButton.setBounds(397, 236, 98, 37);
        frame.getContentPane().add(btnNewButton);

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnSair.setBounds(397, 304, 98, 37);
        frame.getContentPane().add(btnSair);
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);         
            };
        });

        JLabel lblShowDoMilho = new JLabel("    Show Do Milh\u00E3o: \r\nModo Desenvolvedor");
        lblShowDoMilho.setForeground(new Color(0, 0, 0));
        lblShowDoMilho.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 30));
        lblShowDoMilho.setBounds(246, 64, 399, 74);
        frame.getContentPane().add(lblShowDoMilho);
    }
    
    private void trocarTelaCriarJogador() {
        this.frame.setVisible(false);
        TelaJogador telaCriarJogador = new TelaJogador();
        telaCriarJogador.show();
    }
    
   
    
    private void trocarTelaRecorde() {
        this.frame.setVisible(false);
        TelaRecorde telaRecorde = new TelaRecorde();
        telaRecorde.show();
    }
}
