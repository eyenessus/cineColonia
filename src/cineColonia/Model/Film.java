package cineColonia.Model;

import java.util.Date;
/**
 * Film - Model class for Film
 * @author Emerson S.
 * @version 1.0
 * @since 01-02-2025
 */
public class Film {
    private Long id;
    private String title;
    private Date date;
    private Category category;

    /**
     * Get the id of the film
     * @return id of the film
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id of the film
     * @param id id of the film
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the title of the film
     * @param title title of the film
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Get the title of the film
     * @return title of the film
     */
    public String getTitle(){
        return title;
    }

    /**
     * Set the title of the film
     * @param title title of the film
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Get the date of the film
     * @return date of the film
     */
    public Date getDate(){
        return date;
    }

    /**
     * Set the date of the film
     * @param date date of the film
     */
    public void setCategory(Category category){
        this.category = category;
    }

    /**
     * Get the category of the film
     * @return category of the film
     */
    public Category getCategory(){
        return category;
    }
}
