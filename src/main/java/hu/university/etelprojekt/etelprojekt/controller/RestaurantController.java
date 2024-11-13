package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Restaurant;
import hu.university.etelprojekt.etelprojekt.service.RestaurantService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Get restaurant by name
    @GetMapping("/{name}")
    public ResponseEntity<Restaurant> getRestaurantByName(@PathVariable("name") String name) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantByName(name);
        return restaurant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get restaurants by category
    @GetMapping("/category/{categoryName}")
    public List<Restaurant> getRestaurantsByCategory(@PathVariable("categoryName") String categoryName) {
        return restaurantService.getRestaurantsByCategory(categoryName);
    }

    // Get restaurants by city
    @GetMapping("/city/{cityName}")
    public List<Restaurant> getRestaurantsByCity(@PathVariable("cityName") String cityName) {
        return restaurantService.getRestaurantsByCity(cityName);
    }

    // Get restaurants by delivery fee range
    @GetMapping("/delivery-fee")
    public List<Restaurant> getRestaurantsByDeliveryFee(@RequestParam Double minFee, @RequestParam Double maxFee) {
        return restaurantService.getRestaurantsByDeliveryFee(minFee, maxFee);
    }

    // Get restaurants by description containing a keyword
    @GetMapping("/description")
    public List<Restaurant> getRestaurantsByDescription(@RequestParam String keyword) {
        return restaurantService.getRestaurantsByDescription(keyword);
    }

    // Create a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurant);
    }

    // Update an existing restaurant
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Long id,
            @RequestBody Restaurant restaurant) {
        restaurant.setRestaurantId(id); // Ensure the ID is set
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }

    // Delete a restaurant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
