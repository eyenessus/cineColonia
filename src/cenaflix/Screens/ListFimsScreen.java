package cenaflix.Screens;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cenaflix.DAO.FilmDAO;
import cenaflix.Model.Film;

public class ListFimsScreen extends JFrame {
    public ListFimsScreen() {
        setSize(800, 600);
        setTitle("Cenaflix - Lista de filmes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        initalizeComponents();
    }

    private void initalizeComponents() {
        JLabel title = new JLabel("CENAFLIX - Lista de Filmes");
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FilmDAO filmDAO = new FilmDAO();

        String[] columnsName = { "ID", "Título", "Data de Lançamento", "Categoria" };

        // Table with scroll
        JTable table = new JTable();
        JScrollPane scroll = new JScrollPane(table);

        // Table model
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnsName);
        table.setModel(model);

        // Table data
        List<Film> list = filmDAO.listFilms();
        list.forEach(film -> {
            model.addRow(new Object[] { film.getId(), film.getTitle(), film.getDate(), film.getCategory().getName() });
        });

        add(title, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }

}
