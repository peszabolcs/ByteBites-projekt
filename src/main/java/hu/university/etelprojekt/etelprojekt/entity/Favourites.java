package hu.university.etelprojekt.etelprojekt.entity;

import java.io.Serializable;
import jakarta.persistence.*;

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

    // Default constructor
    public Favourites() {
    }

    // Constructor with parameters
    public Favourites(FavouritesId id, User user, Restaurant restaurant, Dish dish, String favType) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.dish = dish;
        this.favType = favType;
    }

    // Getters and Setters
    public FavouritesId getId() {
        return id;
    }

    public void setId(FavouritesId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public String getFavType() {
        return favType;
    }

    public void setFavType(String favType) {
        this.favType = favType;
    }

    @Override
    public String toString() {
        return "Favourites [id=" + id + ", user=" + user + ", restaurant=" + restaurant + ", dish=" + dish
                + ", favType=" + favType + "]";
    }
}
