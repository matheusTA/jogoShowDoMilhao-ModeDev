package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.JogadorController;
import model.Jogador;

public class TelaRecorde extends JFrame {

    private JPanel contentPane;
    private Jogador[] recordes;

    public TelaRecorde() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }

    public void iniciarRecordes() {
        JogadorController jogadorController = new JogadorController();
        this.recordes = jogadorController.carregarRecordes();
    }
}
