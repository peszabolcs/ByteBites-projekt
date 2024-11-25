package hu.university.etelprojekt.etelprojekt.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favourites")
public class Favourites implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FavouritesId id; // Composite key (user_id, restaurant_id, dish_id)

    @ManyToOne
    @MapsId("userId") // Change 'userid' to 'userId' to match the field name in FavouritesId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("restaurantId") // 'restaurantId' already matches, no change needed here
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @MapsId("dishId") // Change 'dish_id' to 'dishId' to match the field name in FavouritesId
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(name = "favourite_type", nullable = false)
    private String favType;


    @Override
    public String toString() {
        return "Favourites [id=" + id + ", user=" + user + ", restaurant=" + restaurant + ", dish=" + dish
                + ", favType=" + favType + "]";
    }
}
