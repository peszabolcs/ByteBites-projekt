package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Favourites;
import hu.university.etelprojekt.etelprojekt.entity.FavouritesId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, FavouritesId> {

    // Save or update a favourite (CRUD operations are provided by JpaRepository)
    @SuppressWarnings({ "unchecked", "null" })
    Favourites save(Favourites favourite);

    // Find a favourite by user_id, restaurant_id, and dish_id
    Optional<Favourites> findByUserIdAndRestaurantIdAndDishId(Long user_id, Long restaurant_id, Long dish_id);

    // Find all favourites by user_id
    List<Favourites> findByUserId(Long user_id);

    // Find all favourites by restaurant_id
    List<Favourites> findByRestaurantId(Long restaurant_id);

    // Find all favourites by dish_id
    List<Favourites> findByDishId(Long dish_id);

    // Find all favourites by user_id and favourite_type
    List<Favourites> findByUserIdAndFavouriteType(Long user_id, String favourite_type);

    // Delete a favourite by user_id, restaurant_id, and dish_id
    void deleteByUserIdAndRestaurantIdAndDishId(Long user_id, Long restaurant_id, Long dish_id);

    // Custom query to find favourites of a specific type for a user
    @Query("SELECT f FROM Favourites f WHERE f.user_id = :user_id AND f._type = :favourite_type")
    List<Favourites> findFavouritesByUserIdAndType(Long user_id, String favourite_type);

    // Custom query to get count of a specific favourite type by user
    @Query("SELECT COUNT(f) FROM Favourites f WHERE f.user_Id = :user_id AND f.favourite_type = :favourite_type")
    long countFavouritesByUserIdAndType(Long user_id, String favourite_type);

    // Find all favourites for a specific user, filtered by dish
    List<Favourites> findByUserIdAndDishId(Long user_id, Long dish_id);

    // Find all favourites by type (restaurant or dish)
    List<Favourites> findByFavouriteType(String favourite_type);

    // Find if a user has a specific restaurant as a favorite
    @Query("SELECT f FROM Favourite f WHERE f.userId = :user_id AND f.restaurant_id = :restaurant_id")
    List<Favourites> findByUserAndRestaurant(@Param("user_id") Long user_Id,
            @Param("restaurant_id") Long restaurant_id);

    // Find if a user has a specific dish as a favorite
    @Query("SELECT f FROM Favourite f WHERE f.user_id = :user_id AND f.dish_id = :dish_id")
    List<Favourites> findByUserAndDish(@Param("user_id") Long user_id, @Param("dish_id") Long dish_id);

}
