package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Favourites;
import hu.university.etelprojekt.etelprojekt.entity.FavouritesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, FavouritesId> {

    // Find all favourites by userId
    List<Favourites> findByUser_UserId(Long userId);

    // Find all favourites by restaurantId
    List<Favourites> findByRestaurant_RestaurantId(Long restaurantId);

    // Find all favourites by dishId
    List<Favourites> findByDish_Id(Long dishId); // Corrected to match 'dishId' in the Dish entity

    // Optionally, find by favourite type (if needed)
    List<Favourites> findByFavType(String favType);
}
