package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Dish;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    // Find a Dish by its name
    List<Dish> findByName(String dishName);

}
