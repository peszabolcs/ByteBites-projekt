package hu.university.etelprojekt.etelprojekt.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "dish")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dish_id;

    private String name;

    private Double price;

    private String description;

    // This represents the relationship to Menu
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false) // 'menu_id' refers to the column in the 'dish' table
    private Menu menu;

    // Getters and Setters
    public Long getId() {
        return dish_id;
    }

    public void setId(Long id) {
        this.dish_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
