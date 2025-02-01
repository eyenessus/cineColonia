package cenaflix.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cenaflix.Database.Conexao;
import cenaflix.Model.Category;
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

    public List<Film> searchFilm(String title) {
        try {
            String query = "SELECT * FROM filmes WHERE nome = ?";
            if (dataBase.conectar()) {
                PreparedStatement st = dataBase.conn.prepareStatement(query);
                st.setString(1, title);
                ResultSet result = st.executeQuery();

                List<Film> filmList = new ArrayList<Film>();

                if (result.next()) {
                    Film film = new Film();
                    film.setTitle(result.getString("nome"));
                    film.setDate(result.getDate("datalancamento"));
                    film.setCategory(new Category(result.getString("categoria")));
                    filmList.add(film);
                }
                dataBase.desconectar();
                return filmList;

            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro interno, tente novamente mais tarde!");
            return null;
        }
    }
}
