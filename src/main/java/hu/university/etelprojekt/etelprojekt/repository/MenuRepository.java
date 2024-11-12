package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    // Find a menu by its ID
    @SuppressWarnings("null")
    Optional<Menu> findById(Long menuId);

    // Find a menu by its name
    Optional<Menu> findByMenuName(String menuName);

    // Find all menus for a specific restaurant
    List<Menu> findByRestaurantId(Long restaurantId);

    // Delete a menu by its ID
    void deleteById(@SuppressWarnings("null") Long menuId);
}
