package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // Correctly matches the Java field name "restaurantName"
    Optional<Restaurant> findByRestaurantName(String restaurantName);

    // Correct method for finding restaurants by category name
    List<Restaurant> findByCategory_CategoryName(String categoryName);

    // Correct method for finding restaurants by city name in the address
    List<Restaurant> findByAddress_City(String cityName);

    // Correctly matches the deliveryFee field in the Restaurant entity
    List<Restaurant> findByDeliveryFeeBetween(Double minFee, Double maxFee);

    // Correct method for finding restaurants by a keyword in their description
    List<Restaurant> findByDescriptionContaining(String keyword);
}
