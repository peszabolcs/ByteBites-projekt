package hu.university.etelprojekt.etelprojekt.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dish")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long dishId;

    private String name;
    private String description;
    private Double price;
    private String picture_url;


    // This represents the relationship to Menu
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false) // 'menu_id' refers to the column in the 'dish' table
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
