package br.com.novaroma.showDoMilhaoModoDev.apresentacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.novaroma.showDoMilhaoModoDev.negocio.JogadorController;
import br.com.novaroma.showDoMilhaoModoDev.negocio.PerguntaController;

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
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBackground(new Color(0, 0, 0));
        frame.getContentPane().setBackground(new Color(51, 51, 255));
        frame.setBounds(100, 100, 450, 300);

        frame.getContentPane().setLayout(null);

        JButton btnJogar = new JButton("Jogar");
        btnJogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                trocarTelaPergunta();
            };
        });
        btnJogar.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnJogar.setBounds(172, 96, 98, 37);
        frame.getContentPane().add(btnJogar);

        JButton btnNewButton = new JButton("Recorde");
        btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               trocarTelaRecorde();
                
            };
        });
        btnNewButton.setBounds(172, 154, 98, 37);
        frame.getContentPane().add(btnNewButton);

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnSair.setBounds(172, 213, 98, 37);
        frame.getContentPane().add(btnSair);
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);         
            };
        });

        JLabel lblShowDoMilho = new JLabel("    Show Do Milh\u00E3o: \r\nModo Desenvolvedor");
        lblShowDoMilho.setForeground(new Color(255, 255, 0));
        lblShowDoMilho.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 24));
        lblShowDoMilho.setBounds(66, 11, 330, 74);
        frame.getContentPane().add(lblShowDoMilho);
    }
    
    private void trocarTelaPergunta() {
        this.frame.setVisible(false);
        TelaPergunta telaPergunta = new TelaPergunta();
        telaPergunta.show();
    }
    
    private void trocarTelaRecorde() {
        this.frame.setVisible(false);
        TelaRecorde telaRecorde = new TelaRecorde();
        telaRecorde.show();
    }
}
