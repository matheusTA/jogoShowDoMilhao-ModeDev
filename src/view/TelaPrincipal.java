package view;

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
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBackground(new Color(0, 0, 0));
        frame.getContentPane().setBackground(new Color(102, 153, 153));
        frame.setBounds(100, 100, 450, 300);
        
        frame.getContentPane().setLayout(null);
        
        JButton btnJogar = new JButton("Jogar");
        btnJogar.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnJogar.setBounds(172, 96, 98, 37);
        frame.getContentPane().add(btnJogar);
        
        JButton btnNewButton = new JButton("Recorde");
        btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton.setBounds(172, 154, 98, 37);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Agency FB", Font.PLAIN, 24));
        btnSair.setBounds(172, 213, 98, 37);
        frame.getContentPane().add(btnSair);
        
        JLabel lblShowDoMilho = new JLabel("Show Do Milh\u00E3o: Modo Desenvolvedor");
        lblShowDoMilho.setForeground(new Color(204, 204, 204));
        lblShowDoMilho.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 24));
        lblShowDoMilho.setBounds(39, 23, 371, 42);
        frame.getContentPane().add(lblShowDoMilho);
    }
}
