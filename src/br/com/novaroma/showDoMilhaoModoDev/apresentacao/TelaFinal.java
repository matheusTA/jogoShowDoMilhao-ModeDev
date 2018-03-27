package br.com.novaroma.showDoMilhaoModoDev.apresentacao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;

public class TelaFinal extends JFrame {

    private JPanel contentPane;
    private String status;

    public TelaFinal(Jogador jogador) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 433);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 235, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setLocationRelativeTo(null);

        JButton btnSair = new JButton("Sair!");
        btnSair.setFont(new Font("Agency FB", Font.PLAIN, 20));
        btnSair.setBounds(394, 336, 105, 33);
        contentPane.add(btnSair);
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            };
        });

        JLabel lblNewLabel = new JLabel("nome\r\n");
        lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
        lblNewLabel.setBounds(289, 152, 314, 66);
        contentPane.add(lblNewLabel);
        lblNewLabel.setText("Nome: " + jogador.getNome());

        JLabel lblNewLabel_1 = new JLabel("O jogo acabou\r\n");
        lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 34));
        lblNewLabel_1.setBounds(367, 11, 159, 41);
        contentPane.add(lblNewLabel_1);

        if (jogador.getPontos() == 1000000) {
            this.status = "VOCÊ GANHOU O JOGO, PARABÊNS";
        } else {
            this.status = "VOCÊ PERDEU";
        }

        JLabel lblNewLabel_2 = new JLabel(this.status);
        lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
        lblNewLabel_2.setBounds(270, 63, 353, 78);
        contentPane.add(lblNewLabel_2);

        JLabel lblPontos = new JLabel("pontos");
        lblPontos.setFont(new Font("Agency FB", Font.PLAIN, 30));
        lblPontos.setBounds(289, 229, 314, 51);
        contentPane.add(lblPontos);
        lblPontos.setText("Pontos: " + jogador.getPontos());

        JButton btnMenu = new JButton("Menu");
        btnMenu.setFont(new Font("Agency FB", Font.PLAIN, 20));
        btnMenu.setBounds(289, 336, 95, 33);
        contentPane.add(btnMenu);
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                trocaTelaMenu();
            };
        });
    }

    private void finaizarJogo() {
        System.exit(0);
    }

    private void trocaTelaMenu() {
        this.setVisible(false);
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.show();
    }
}