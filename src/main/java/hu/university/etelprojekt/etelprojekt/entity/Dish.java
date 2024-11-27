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


    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
