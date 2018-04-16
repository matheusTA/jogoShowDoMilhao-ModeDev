package br.com.novaroma.showDoMilhaoModoDev.apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import br.com.novaroma.showDoMilhaoModoDev.dados.CSVGravador;
import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;
import br.com.novaroma.showDoMilhaoModoDev.negocio.JogadorController;

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
        btnMenu.setFont(new Font("Agency FB", Font.PLAIN, 20));
        btnMenu.setBounds(762, 346, 95, 37);
        contentPane.add(btnMenu);

        JButton btnNewButton = new JButton("Limpar recordes");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JLabel label = new JLabel("Digite a senha:");
                // criar o componente grafico que recebera o que for digitado
                JPasswordField jpf = new JPasswordField();
                // Exibir a janela para o usuario
                JOptionPane.showConfirmDialog(null, new Object[] { label, jpf }, "Senha:", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

                String senhaDigitada = new String(jpf.getPassword());
                if (senhaDigitada.equals("senha123")) {
                    CSVGravador csvGravador = new CSVGravador();
                    JogadorController jogadorController = new JogadorController();
                    csvGravador.limpaArquivoReCordes();
                   iniciarRecordes();

                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                }

            }
        });
        btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 20));
        btnNewButton.setBounds(10, 346, 145, 35);
        contentPane.add(btnNewButton);
    }

    public void iniciarRecordes() {
        JogadorController jogadorController = new JogadorController();
        this.recordes = jogadorController.carregarRecordes();

        String menssagem = "<html>";
        if (this.recordes != null) {
            for (int i = 0; i < recordes.length; i++) {
                menssagem += (i + 1) + "º) Nome: " + recordes[i].getNome() + " //   Pontos: " + recordes[i].getPontos()
                        + "<br>";
            }

            this.label.setText(menssagem);
        } else {
            this.label.setText(menssagem);
        }

    }

    private void trocaTelaMenu() {
        this.setVisible(false);
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.show();
    }
}
