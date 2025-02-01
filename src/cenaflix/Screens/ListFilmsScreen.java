package cenaflix.Screens;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cenaflix.DAO.FilmDAO;
import cenaflix.Interfaces.IFilmDAO;
import cenaflix.Model.Film;

public class ListFilmsScreen extends JFrame {
    private JTable table;
    private IFilmDAO filmDAO;
    private DefaultTableModel model;
    private JFrame backScreen;

    public ListFilmsScreen() {
        filmDAO = new FilmDAO();
        setSize(800, 600);
        setTitle("Cenaflix - Lista de filmes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        initalizeComponents();
    }

    public ListFilmsScreen(JFrame backScreen) {
        this();
        this.backScreen = backScreen;
    }

    private void initalizeComponents() {
        JLabel title = new JLabel("CENAFLIX - Lista de Filmes");
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JButton btnBack = new JButton("Voltar");
        JButton btnDelete = new JButton("Excluir");
        JButton btnEdit = new JButton("Editar");

        btnBack.addActionListener(this::btnBackActionPerformed);
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        btnEdit.addActionListener(this::btnEditActionPerformed);

        String[] columnsName = { "ID", "Título", "Data de Lançamento", "Categoria" };

        // Table with scroll
        table = new JTable();
        JScrollPane scroll = new JScrollPane(table);

        // Table model
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnsName);
        table.setModel(model);

        // Table data
        List<Film> list = filmDAO.listFilms();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        list.forEach(film -> {
            model.addRow(new Object[] { film.getId(), film.getTitle(),sdf.format(film.getDate()), film.getCategory().getName() });
        });

        add(title, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnBack);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        this.dispose();
        if (backScreen != null) {
            backScreen.setVisible(true);
        }
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        int lineRow = table.getSelectedRow();
        if (lineRow == -1) {
            System.out.println("Nenhuma linha selecionada");
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada");
            return;
        }

        String id = table.getValueAt(lineRow, 0).toString();
        boolean confirmDelete = filmDAO.deleteFilm(id);
        if (confirmDelete) {
            model.removeRow(lineRow);
        }

    }

    private void btnEditActionPerformed(ActionEvent evt) {
        
        int lineRow = table.getSelectedRow();
        if (lineRow == -1) {
            System.out.println("Nenhuma linha selecionada");
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada");
            return;
        }

        Long id = (Long) table.getValueAt(lineRow, 0);
        Film film = filmDAO.getFilmByID(id);
        if (film != null) {
            setVisible(false);
            new SignUpScreen(film,this);
        } else {
            JOptionPane.showMessageDialog(null, "Filme não encontrado!");
        }
    }
}
