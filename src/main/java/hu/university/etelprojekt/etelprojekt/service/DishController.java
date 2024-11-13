package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Dish;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    // Get all dishes
    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        List<Dish> dishes = dishService.getAllDishes();
        return ResponseEntity.ok(dishes);
    }

    // Get dish by ID
    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
        Optional<Dish> dish = dishService.getDishById(id);
        return dish.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get dishes by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Dish>> getDishesByName(@PathVariable String name) {
        List<Dish> dishes = dishService.getDishesByName(name);
        return dishes.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(dishes);
    }

    // Get dishes by menu ID
    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<Dish>> getDishesByMenuId(@PathVariable Long menuId) {
        List<Dish> dishes = dishService.getDishesByMenuId(menuId);
        return dishes.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(dishes);
    }

    // Create or update a dish
    @PostMapping
    public ResponseEntity<Dish> createOrUpdateDish(@RequestBody Dish dish) {
        Dish savedDish = dishService.saveDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDish);
    }

    // Delete dish by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDishById(@PathVariable Long id) {
        dishService.deleteDishById(id);
        return ResponseEntity.noContent().build();
    }
}
