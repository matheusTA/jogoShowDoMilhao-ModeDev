package br.com.novaroma.showDoMilhaoModoDev.apresentacao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;
import br.com.novaroma.showDoMilhaoModoDev.negocio.JogadorController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRecordeComScroll extends JFrame {

    private JPanel contentPane;

    private Jogador[] recordes;
    JScrollPane scrollPane;
    JLabel label;
    private JLabel lblRecordes;

    public TelaRecordeComScroll() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 433);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 235, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setLocationRelativeTo(null);

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(201, 59, 491, 291);
        scrollPane.getViewport().setBackground(new Color(250, 235, 215));
        contentPane.add(scrollPane);

        label = new JLabel("<html></html>");
        label.setBackground(new Color(127, 255, 212));
        label.setFont(new Font("Agency FB", Font.PLAIN, 22));
        iniciarRecordes();
        scrollPane.setViewportView(label);

        lblRecordes = new JLabel("Recordes");
        lblRecordes.setFont(new Font("Agency FB", Font.PLAIN, 30));
        lblRecordes.setBounds(403, 11, 87, 37);
        contentPane.add(lblRecordes);

        JButton btnMenu = new JButton("Menu");
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                trocaTelaMenu();
            }
        });
        btnMenu.setFont(new Font("Agency FB", Font.PLAIN, 26));
        btnMenu.setBounds(762, 346, 95, 37);
        contentPane.add(btnMenu);
    }

    public void iniciarRecordes() {
        JogadorController jogadorController = new JogadorController();
        this.recordes = jogadorController.carregarRecordes();

        String menssagem = "<html>";
        for (int i = 0; i < recordes.length; i++) {
            menssagem += (i + 1) + "º) Nome: " + recordes[i].getNome() + " //   Pontos: " + recordes[i].getPontos()
                    + "<br>";
        }

        this.label.setText(menssagem);
    }

    private void trocaTelaMenu() {
        this.setVisible(false);
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.show();
    }
}
