package br.com.novaroma.showDoMilhaoModoDev.apresentacao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.novaroma.showDoMilhaoModoDev.entidades.Jogador;
import br.com.novaroma.showDoMilhaoModoDev.negocio.JogadorController;

public class TelaRecorde extends JFrame {

    private JPanel contentPane;
    private Jogador[] recordes;
    JLabel lblNewLabel;

    public TelaRecorde() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 246, 424, -233);
        contentPane.add(scrollPane);

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(10, 11, 414, 239);

        contentPane.add(lblNewLabel);

        iniciarRecordes();
    }

    public void iniciarRecordes() {
        JogadorController jogadorController = new JogadorController();
        this.recordes = jogadorController.carregarRecordes();

        String menssagem = "<html>";
        for (int i = 0; i < recordes.length; i++) {
            menssagem += "Nome: " + recordes[i].getNome() + "    Pontos: " + recordes[i].getPontos() + "<br>";
        }
        lblNewLabel.setText(menssagem + "</html>");

    }
}
