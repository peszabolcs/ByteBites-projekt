package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Favourites;
import hu.university.etelprojekt.etelprojekt.entity.FavouritesId;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, FavouritesId> {

    /*
     * // Custom query method to find all favourites by userId
     * List<Favourites> findByUserId(Long userId);
     * 
     * // Custom query method to find all favourites by restaurantId
     * List<Favourites> findByRestaurantId(Long restaurantId);
     * 
     * // Custom query method to find all favourites by dishId
     * List<Favourites> findByDishId(Long dishId);
     * 
     * // Custom query method to find a specific favourite by userId, restaurantId,
     * and
     * // dishId
     * Favourites findById_UserIdAndId_RestaurantIdAndId_DishId(Long userId, Long
     * restaurantId, Long dishId);
     */
}
