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

    public List<Film> listFilms() {
        try {
            String query = "SELECT * FROM filmes";
            if (dataBase.conectar()) {
                PreparedStatement st = dataBase.conn.prepareStatement(query);
                ResultSet result = st.executeQuery();

                List<Film> filmList = new ArrayList<Film>();

                while (result.next()) {
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

    public List<Film> searchFilm(String title, String category) {
        try {
            String query = "SELECT * FROM filmes WHERE";
            if (!title.isEmpty()) {
                query += " nome LIKE ?";
            }

            if (title.isEmpty() && category.isEmpty()) {
                return listFilms();
            }

            if (dataBase.conectar()) {
                PreparedStatement st = dataBase.conn.prepareStatement(query);
                Boolean titleIsEmpty = title.isEmpty();
                if(!titleIsEmpty) {
                    st.setString(1, "%" + title + "%");
                }

                if (!category.isEmpty()) {
                    query += titleIsEmpty ? "categoria LIKE ?" : "OR categoria LIKE ?";
                    st.setString(titleIsEmpty ? 1 : 2, "%" + category + "%");
                }

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

    public boolean deleteFilm(String title) {
        try {
            String query = "DELETE FROM filmes WHERE nome = ?";
            if (dataBase.conectar()) {
                PreparedStatement st = dataBase.conn.prepareStatement(query);
                st.setString(1, title);
                st.executeUpdate();
                dataBase.desconectar();
                JOptionPane.showMessageDialog(null, "Filme deletado com sucesso!");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao deletar!");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro interno, tente novamente mais tarde!");
            return false;
        }
    }

    public boolean updateFilm(Film film) {
        try {
            String query = "UPDATE filmes SET nome = ? datalancamento = ?, categoria = ? WHERE nome = ?";
            if (dataBase.conectar()) {
                PreparedStatement st = dataBase.conn.prepareStatement(query);
                st.setString(1, film.getTitle());
                st.setDate(1, new java.sql.Date(film.getDate().getTime()));
                st.setString(2, film.getCategory().getName());
                st.setString(3, film.getTitle());
                st.executeUpdate();
                dataBase.desconectar();
                JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso!");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro interno, tente novamente mais tarde!");
            return false;
        }
    }

}
