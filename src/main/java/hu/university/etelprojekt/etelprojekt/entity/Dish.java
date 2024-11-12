package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long dishId;

    @Column(name = "dish_name", nullable = false)
    private String dishName;

    @Column(name = "description")
    private String dishDescription;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "picture_url")
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToMany
    @JoinTable(name = "dish_allergen", joinColumns = @JoinColumn(name = "dish_id"), inverseJoinColumns = @JoinColumn(name = "allergen_id"))
    private List<Allergen> allergens;

    // Default constructor
    public Dish() {
    }

    // Constructor with all fields
    public Dish(Long dishId, String dishName, String dishDescription, Double price, String pictureUrl, Menu menu,
            List<Allergen> allergens) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.menu = menu;
        this.allergens = allergens;
    }

    // Getters and Setters
    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergen> allergens) {
        this.allergens = allergens;
    }

    @Override
    public String toString() {
        return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", dishDescription=" + dishDescription + ", price="
                + price + ", pictureUrl=" + pictureUrl + ", menu=" + menu + ", allergens=" + allergens + "]";
    }
}