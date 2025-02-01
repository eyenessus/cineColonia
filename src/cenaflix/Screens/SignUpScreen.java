package cenaflix.Screens;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.*;

import cenaflix.DAO.FilmDAO;
import cenaflix.Model.Category;
import cenaflix.Model.Film;

/**
 * SignUpScreen - Screen to register a new film
 * 
 * @author Emerson S.
 * @version 1.0
 * @since 01-02-2025
 * @version 1.0
 */
public class SignUpScreen extends JFrame {
    private boolean isUpdate = false;
    private Film film;
    private JFrame backScreen;

    public SignUpScreen() {
        setSize(800, 600);
        setTitle("Cenaflix - Cadastro de filmes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        initalizeComponents();
    }

    public SignUpScreen(Film film,JFrame backScreen) {
        isUpdate = true;
        this.film = film;
        this.backScreen = backScreen;
        setSize(800, 600);
        setTitle("Cenaflix - Atualização de filmes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        initalizeComponents();
    }

  

    /**
     * Initialize the components of the screen
     * 
     * @author Emerson S.
     * @since 01-02-2025
     * @version 1.0
     */
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

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        textFieldDate.setText(LocalDate.now().format(dateFormatter));

        textFieldDate.setColumns(20);
        mainPanel.add(textFieldDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel labelCategory = new JLabel("Category:");
        mainPanel.add(labelCategory, gbc);

        JTextField categoryField = new JTextField();

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(categoryField, gbc);

        JPanel buttonPanel = new JPanel();
        JButton buttonRegister = new JButton("Registrar");
        JButton buttonClean = new JButton("Limpar");
        JButton buttonList = new JButton("Listagem");
        JButton buttonBack = new JButton("Voltar");
        buttonPanel.setLayout(new FlowLayout());
        
        buttonPanel.add(buttonClean);
        buttonPanel.add(buttonRegister);
        
        if (isUpdate) {
            labelTitle.setText("CENAFLIX - Atualização de filmes");
            buttonRegister.setText("Atualizar");
            textFieldName.setText(film.getTitle());
            textFieldDate.setText(film.getDate().toString());
            categoryField.setText(film.getCategory().getName());
            buttonPanel.add(buttonBack);
        } else {
            buttonRegister.setText("Registrar");
            buttonPanel.add(buttonList);
        }

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

       
        mainPanel.add(buttonPanel, gbc);
        add(mainPanel);

        buttonBack.addActionListener(e -> {
            if (e.getSource() == buttonBack) {
                setVisible(false);
                backScreen.setVisible(true);
            }
        });

        buttonRegister.addActionListener(e -> {
            if (textFieldName.getText().isEmpty() || textFieldDate.getText().isEmpty()
                    || textFieldDate.getText().equals("dd/MM/yyyy")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
                return;
            }

            try {
                if (e.getSource() == buttonRegister) {
                    String name = textFieldName.getText();
                    String date = textFieldDate.getText();
                    String category = categoryField.getText();
                    Date dateParse = new SimpleDateFormat("dd/MM/yyyy").parse(date);

                    if (date.length() != 10) {
                        JOptionPane.showMessageDialog(null, "Data inválida!");
                        return;
                    }

                    Film film = new Film();
                    FilmDAO filmDAO = new FilmDAO();

                    film.setTitle(name);
                    film.setDate(dateParse);
                    film.setCategory(new Category(category));

                    textFieldName.setText("");
                    textFieldDate.setText("dd/MM/yyyy");
                    categoryField.setText("");

                    if (isUpdate) {
                        filmDAO.updateFilm(film);
                        JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso!");
                        setVisible(false);
                        return;
                    }
                    filmDAO.insertFilm(film);
                }
            } catch (Exception ParseException) {
                JOptionPane.showMessageDialog(null, "Data inválida!");
            }
        });

        buttonClean.addActionListener(e -> {
            if (e.getSource() == buttonClean) {
                textFieldName.setText("");
                textFieldDate.setText("dd/MM/yyyy");
                categoryField.setText("");
            }
        });

        buttonList.addActionListener(e -> {
            if (e.getSource() == buttonList) {
                setVisible(false);
                new ListFilmsScreen(this);
            }
        });

        setVisible(true);
    }

}
