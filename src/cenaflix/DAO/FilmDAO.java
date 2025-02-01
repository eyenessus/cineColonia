package cenaflix.DAO;

import java.awt.Dialog;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import cenaflix.Database.Conexao;
import cenaflix.Model.Film;

public class FilmDAO {
    private Conexao dataBase;

    public FilmDAO() {
        dataBase = new Conexao();
    }

    public boolean insertFilm(Film film) {
        try {
            if (dataBase.conectar()) {
                String query = "INSERT INTO filmes (nome, datalancamento, categoria) VALUES(? , ? , ?)";
                PreparedStatement st = dataBase.conn.prepareStatement(query);
                st.setString(1, film.getTitle());
                st.setDate(2, new java.sql.Date(film.getDate().getTime()));
                st.setString(3, film.getCategory().getName());
                st.executeUpdate();
                dataBase.desconectar();
                JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro interno, tente novamente mais tarde!");
            return false;
        }
    }
}
