package cineColonia.Interfaces;

import java.util.List;

import cineColonia.Model.Film;
/**
 * IFilmDAO - Interface for FilmDAO
 * @author Emerson S.
 * @version 1.0
 */
public interface IFilmDAO {

    /**
     * Store a film in the database
     * @param film Film to be stored
     * @return true if the film was stored successfully, false otherwise
     */
    public boolean insertFilm(Film film);

    /**
     * List all films stored in the database
     * @return List of films
     */
    public List<Film> listFilms();

    /**
     * Update a film in the database
     * @param film Film to be updated
     * @return true if the film was updated successfully, false otherwise
     */
    public boolean updateFilm(Film film);

    /**
     * Delete a film from the database by title
     * @param title title film to be deleted
     * @return true if the film was deleted successfully, false otherwise
     */
    public boolean deleteFilm(String title);

    /**
     * Search for a film in the database
     * @param title Title of the film to be searched | Optional
     * @param category Category of the film to be searched | Optional
     * @return Film if found, null otherwise
     */
    public List<Film> searchFilm(String title, String category);

    /**
     * Get a film by its ID
     * @param id ID of the film
     * @return Film if found, null otherwise
     */
    public Film getFilmByID(Long id);
}