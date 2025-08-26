package cineColonia.Model;
/**
 * Category - Model class for Category
 * @author Emerson S.
 * @version 1.0
 * @since 01-02-2025
 */
public class Category {
    private String name;

    public Category(String name){
        this.name = name;
    }
    
    /**
     * Set the name of the category
     * @return name of the category
     */
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
