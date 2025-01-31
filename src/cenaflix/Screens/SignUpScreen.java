package cenaflix.Screens;

import java.awt.*;
import javax.swing.*;

public class SignUpScreen extends JFrame {
    public SignUpScreen() {
        setSize(800, 600);
        setTitle("Cenaflix - Cadastro de filmes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));
        initalizeComponents();
    }

    private void initalizeComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        JLabel labelTitle = new JLabel("CENAFLIX");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 40));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(labelTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel labelName = new JLabel("Nome do Filme:");
        mainPanel.add(labelName, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField textFieldName = new JTextField(20);
        mainPanel.add(textFieldName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        JLabel labelDate = new JLabel("Data de Lançamento:");
        mainPanel.add(labelDate, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField textFieldYear = new JTextField(20);
        mainPanel.add(textFieldYear, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel labelCategory = new JLabel("Category:");
        mainPanel.add(labelCategory, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField textFieldCategory = new JTextField(20);
        mainPanel.add(textFieldCategory, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton buttonRegister = new JButton("Registrar");
        JButton buttonClean = new JButton("Limpar");

        buttonPanel.add(buttonRegister);
        buttonPanel.add(buttonClean);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        mainPanel.add(buttonPanel, gbc);
        add(mainPanel);
        setVisible(true);
    }
}
