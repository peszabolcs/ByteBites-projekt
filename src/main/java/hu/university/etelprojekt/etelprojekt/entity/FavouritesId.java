package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavouritesId implements Serializable {

    private Long userId;
    private Long restaurantId;
    private Long dishId;

    // Default constructor
    public FavouritesId() {
    }

    public FavouritesId(Long userId, Long restaurantId, Long dishId) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.dishId = dishId;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FavouritesId that = (FavouritesId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(restaurantId, that.restaurantId) &&
                Objects.equals(dishId, that.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, restaurantId, dishId);
    }
}
