package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Long> {

    // Save or update a favourite (CRUD operations are provided by JpaRepository)
    @SuppressWarnings("unchecked")
    Favourites save(Favourites favourite);

    // Find a favourite by user_id, restaurant_id, and dish_id
    Optional<Favourites> findByUserIdAndRestaurantIdAndDishId(Long userId, Long restaurantId, Long dishId);

    // Find all favourites by user_id
    List<Favourites> findByUserId(Long userId);

    // Find all favourites by restaurant_id
    List<Favourites> findByRestaurantId(Long restaurantId);

    // Find all favourites by dish_id
    List<Favourites> findByDishId(Long dishId);

    // Find all favourites by user_id and favourite_type
    List<Favourites> findByUserIdAndFavouriteType(Long userId, String favouriteType);

    // Delete a favourite by user_id, restaurant_id, and dish_id
    void deleteByUserIdAndRestaurantIdAndDishId(Long userId, Long restaurantId, Long dishId);

    // Custom query to find favourites of a specific type for a user
    @Query("SELECT f FROM Favourites f WHERE f.userId = :userId AND f.favouriteType = :favouriteType")
    List<Favourites> findFavouritesByUserIdAndType(Long userId, String favouriteType);

    // Custom query to get count of a specific favourite type by user
    @Query("SELECT COUNT(f) FROM Favourites f WHERE f.userId = :userId AND f.favouriteType = :favouriteType")
    long countFavouritesByUserIdAndType(Long userId, String favouriteType);

    // Find all favourites for a specific user, filtered by dish
    List<Favourites> findByUserIdAndDishId(Long userId, Long dishId);

    // Find all favourites by type (restaurant or dish)
    List<Favourites> findByFavouriteType(String favouriteType);

    // Find if a user has a specific restaurant as a favorite
    @Query("SELECT f FROM Favourite f WHERE f.userId = :userId AND f.restaurantId = :restaurantId")
    List<Favourites> findByUserAndRestaurant(@Param("userId") Long userId, @Param("restaurantId") Long restaurantId);

    // Find if a user has a specific dish as a favorite
    @Query("SELECT f FROM Favourite f WHERE f.userId = :userId AND f.dishId = :dishId")
    List<Favourites> findByUserAndDish(@Param("userId") Long userId, @Param("dishId") Long dishId);

}
