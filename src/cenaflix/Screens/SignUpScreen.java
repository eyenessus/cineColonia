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
        setLayout(new BorderLayout(10, 10));
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
        JFormattedTextField textFieldDate = new JFormattedTextField(new java.text.SimpleDateFormat("dd/MM/yyyy"));
        textFieldDate.setToolTipText("dd/MM/yyyy");
        textFieldDate.setColumns(20);
        textFieldDate.setText("dd/MM/yyyy");

        textFieldDate.setColumns(20);
        mainPanel.add(textFieldDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel labelCategory = new JLabel("Category:");
        mainPanel.add(labelCategory, gbc);

        JComboBox<String> comboBoxCategory = new JComboBox<>();
        comboBoxCategory.addItem("Ação");
        comboBoxCategory.addItem("Aventura");
        comboBoxCategory.addItem("Comédia");
        comboBoxCategory.addItem("Drama");
        comboBoxCategory.addItem("Ficção Científica");
        comboBoxCategory.addItem("Terror");

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(comboBoxCategory, gbc);

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

        buttonRegister.addActionListener(e -> {
            if (textFieldName.getText().isEmpty() || textFieldDate.getText().isEmpty()
                    || textFieldDate.getText().equals("dd/MM/yyyy")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
                return;
            }

            if (e.getSource() == buttonRegister) {
                String name = textFieldName.getText();
                String date = textFieldDate.getText();
                String category = comboBoxCategory.getSelectedItem().toString();
            }
        });

        buttonClean.addActionListener(e -> {
            if (e.getSource() == buttonClean) {
                textFieldName.setText("");
                textFieldDate.setText("dd/MM/yyyy");
                comboBoxCategory.setSelectedIndex(0);
            }
        });

        setVisible(true);
    }

}
