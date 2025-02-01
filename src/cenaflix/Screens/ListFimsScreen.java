package cenaflix.Screens;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


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
        
        String[] columnsName = {"ID", "Título", "Data de Lançamento", "Categoria"};

        // Table with scroll
        JTable table = new JTable();
        JScrollPane scroll = new JScrollPane(table);
         
        // Table model
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnsName);
        table.setModel(model);
        
        // Table data
        model.addRow(new Object[]{1, "Matrix", "1999-03-31", "Ficção Científica"});

        add(title, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }



   
}
