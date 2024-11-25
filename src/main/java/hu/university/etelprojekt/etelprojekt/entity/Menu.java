package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Relationship to Restaurant (add this property)
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false) // restaurant_id in the 'menu' table
    private Restaurant restaurant;

    // This represents the inverse relationship to Dish
    @OneToMany(mappedBy = "menu") // 'menu' is the property in the 'Dish' entity
    private List<Dish> dishes;
}
