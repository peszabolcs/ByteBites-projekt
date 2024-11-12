package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    // Save or update a dish (CRUD operations are provided by JpaRepository)
    @SuppressWarnings({ "unchecked", "null" })
    Dish save(Dish dish);

    // Find a dish by its ID
    @SuppressWarnings("null")
    Optional<Dish> findById(Long dishId);

    // Find all dishes in a specific menu
    List<Dish> findByMenuId(Long menuId);

    // Find dishes by their name (case-insensitive)
    List<Dish> findByDishNameIgnoreCaseContaining(String dishName);

    // Delete a dish by its ID
    void deleteById(@SuppressWarnings("null") Long dishId);

    // Custom query to find dishes under a certain price
    @Query("SELECT d FROM Dish d WHERE d.price < :price")
    List<Dish> findDishesByPriceLessThan(Double price);

    // Custom query to find dishes by menu ID and price range
    @Query("SELECT d FROM Dish d WHERE d.menuId = :menuId AND d.price BETWEEN :minPrice AND :maxPrice")
    List<Dish> findDishesByMenuAndPriceRange(Long menuId, Double minPrice, Double maxPrice);
}
