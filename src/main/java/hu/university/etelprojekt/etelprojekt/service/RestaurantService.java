package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Restaurant;
import hu.university.etelprojekt.etelprojekt.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RestaurantService {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    @Autowired
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // Get all restaurants
    public List<Restaurant> getAllRestaurants() {
        logger.info("Adatbázis lekérdezés folyamatban");
        List<Restaurant> restaurants = restaurantRepository.findAll();
        logger.info("Adatbázis lekérdezés befejeződött, talált éttermek: " + restaurants.size());
        return restaurants;
        }

    // Get a restaurant by name
    public Optional<Restaurant> getRestaurantByName(String restaurantName) {
        return restaurantRepository.findByRestaurantName(restaurantName);
    }

    // Get restaurants by category
    public List<Restaurant> getRestaurantsByCategory(String categoryName) {
        return restaurantRepository.findByCategory_CategoryName(categoryName);
    }

    // Get restaurants by city
    public List<Restaurant> getRestaurantsByCity(String cityName) {
        return restaurantRepository.findByAddress_City(cityName);
    }

    // Get restaurants within a certain delivery fee range
    public List<Restaurant> getRestaurantsByDeliveryFee(Double minFee, Double maxFee) {
        return restaurantRepository.findByDeliveryFeeBetween(minFee, maxFee);
    }

    // Get restaurants by description keyword
    public List<Restaurant> getRestaurantsByDescription(String keyword) {
        return restaurantRepository.findByDescriptionContaining(keyword);
    }

    // Save a new restaurant
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Update an existing restaurant
    public Restaurant updateRestaurant(Restaurant restaurant) {
        if (restaurant.getRestaurantId() == null) {
            throw new IllegalArgumentException("Restaurant ID must be provided for update.");
        }
        return restaurantRepository.save(restaurant);
    }

    // Delete a restaurant by ID
    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}
