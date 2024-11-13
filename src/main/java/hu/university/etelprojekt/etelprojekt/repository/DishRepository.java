package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    /*
     * // Custom query methods can be added here as needed
     * 
     * // Example: Find a Dish by its name
     * List<Dish> findByDishName(String dishName);
     * 
     * // Example: Find all dishes by a specific menu id
     * List<Dish> findByMenu_Id(Long menuId);
     */

}
