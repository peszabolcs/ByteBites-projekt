package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    // Find all menus for a specific restaurant by restaurant ID
    List<Menu> findByRestaurant_RestaurantId(Long restaurantId);

    // Find a menu by its name
    Menu findByName(String name);

    // Custom query: Find all menus that contain a dish with the given name
    List<Menu> findByDishesNameContaining(String dishName);

    // Custom query: Find menus by restaurant ID and menu name
    List<Menu> findByRestaurant_RestaurantIdAndName(Long restaurantId, String menuName);
}
