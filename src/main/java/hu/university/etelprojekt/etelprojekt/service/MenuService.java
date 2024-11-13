package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Menu;
import hu.university.etelprojekt.etelprojekt.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Find menus by restaurant ID
    public List<Menu> getMenusByRestaurantId(Long restaurantId) {
        return menuRepository.findByRestaurant_RestaurantId(restaurantId);
    }

    // Find a menu by its name
    public Menu getMenuByName(String name) {
        return menuRepository.findByName(name);
    }

    // Find menus containing a dish by dish name
    public List<Menu> getMenusByDishName(String dishName) {
        return menuRepository.findByDishesNameContaining(dishName);
    }

    // Find menus by restaurant ID and menu name
    public List<Menu> getMenusByRestaurantIdAndName(Long restaurantId, String menuName) {
        return menuRepository.findByRestaurant_RestaurantIdAndName(restaurantId, menuName);
    }

    // Save or update a menu
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    // Delete a menu by ID
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
