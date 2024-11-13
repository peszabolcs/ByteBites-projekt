package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Dish;
import hu.university.etelprojekt.etelprojekt.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    // Get all dishes
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    // Get dish by ID
    public Optional<Dish> getDishById(Long dishId) {
        return dishRepository.findById(dishId);
    }

    // Get dishes by name
    public List<Dish> getDishesByName(String dishName) {
        return dishRepository.findByName(dishName);
    }

    // Get dishes by menu ID
    public List<Dish> getDishesByMenuId(Long menuId) {
        return dishRepository.findByMenu_Id(menuId);
    }

    // Save or update a dish
    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    // Delete dish by ID
    public void deleteDishById(Long dishId) {
        dishRepository.deleteById(dishId);
    }
}
