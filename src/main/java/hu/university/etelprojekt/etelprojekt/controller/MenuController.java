package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Menu;
import hu.university.etelprojekt.etelprojekt.service.MenuService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // Get all menus by restaurant ID
    @GetMapping("/restaurant/{restaurantId}")
    public List<Menu> getMenusByRestaurantId(@PathVariable Long restaurantId) {
        return menuService.getMenusByRestaurantId(restaurantId);
    }

    // Get a menu by name
    @GetMapping("/name/{name}")
    public Menu getMenuByName(@PathVariable String name) {
        return menuService.getMenuByName(name);
    }

    // Get menus by dish name
    @GetMapping("/dish/{dishName}")
    public List<Menu> getMenusByDishName(@PathVariable String dishName) {
        return menuService.getMenusByDishName(dishName);
    }

    // Get menus by restaurant ID and menu name
    @GetMapping("/restaurant/{restaurantId}/name/{menuName}")
    public List<Menu> getMenusByRestaurantIdAndName(
            @PathVariable Long restaurantId,
            @PathVariable String menuName) {
        return menuService.getMenusByRestaurantIdAndName(restaurantId, menuName);
    }

    // Create or update a menu
    @PostMapping
    public Menu saveMenu(@RequestBody Menu menu) {
        return menuService.saveMenu(menu);
    }

    // Delete a menu by ID
    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
