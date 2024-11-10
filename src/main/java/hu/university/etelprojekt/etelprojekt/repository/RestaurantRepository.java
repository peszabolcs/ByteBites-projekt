package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // Find restaurant by ID
    Optional<Restaurant> findById(Long restaurantId);

    // Find restaurant by name
    Optional<Restaurant> findByRestaurantName(String restaurantName);

    // Save or update restaurant
    @SuppressWarnings("unchecked")
    Restaurant save(Restaurant restaurant);

    // Delete restaurant by ID
    void deleteById(Long restaurantId);

    // Find all restaurants sorted by name
    @Query("SELECT r FROM Restaurant r ORDER BY r.restaurantName ASC")
    List<Restaurant> findAllRestaurantsSortedByName();

    // Find restaurants by category
    @Query("SELECT r FROM Restaurant r WHERE r.categoryId = :categoryId")
    List<Restaurant> findRestaurantsByCategory(@Param("categoryId") Long categoryId);

    // Find restaurants by city (join with address)
    @Query("SELECT r FROM Restaurant r JOIN Address a ON r.addressId = a.addressId WHERE a.city = :city")
    List<Restaurant> findRestaurantsByCity(@Param("city") String city);

    // Count total number of restaurants
    @Query("SELECT COUNT(r) FROM Restaurant r")
    long countRestaurants();

    // Find restaurant by name containing a keyword (partial match)
    @Query("SELECT r FROM Restaurant r WHERE r.restaurantName LIKE %:name%")
    List<Restaurant> findRestaurantsByNameContains(@Param("name") String name);

    // Delete restaurant by name
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.restaurantName = :name")
    void deleteRestaurantByName(@Param("name") String name);

    // Update restaurant's delivery fee by ID
    @Modifying
    @Query("UPDATE Restaurant r SET r.deliveryFee = :deliveryFee WHERE r.restaurantId = :restaurantId")
    void updateDeliveryFeeById(@Param("restaurantId") Long restaurantId, @Param("deliveryFee") Double deliveryFee);

    // Find all restaurants with pagination
    Page<Restaurant> findAll(Pageable pageable);
}
