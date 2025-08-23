package cineColonia.Services;

import cineColonia.DAO.FilmDAO;
import cineColonia.Interfaces.IFilmDAO;
import cineColonia.Model.Film;
import java.util.List;

public class FilmeService {
    private final IFilmDAO filmDAO;

    public FilmeService() {
        filmDAO = new FilmDAO();
    }

    public boolean registrarFilme(Film film) {
        return filmDAO.insertFilm(film);
    }

    public List<Film> listaDeFilmes(){
        List<Film> list = filmDAO.listFilms();
        return list;
    }

    public boolean deleteFilme(String id) {
        return filmDAO.deleteFilm(id);
    }

    public Film obterFilmePorId(Long id) {
        return filmDAO.getFilmByID(id);
    }

    public boolean atualizarFilme(Film film) {
        return filmDAO.updateFilm(film);
    }

}
