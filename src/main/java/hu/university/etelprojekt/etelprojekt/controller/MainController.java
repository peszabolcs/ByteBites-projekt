package hu.university.etelprojekt.etelprojekt.controller;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hu.university.etelprojekt.etelprojekt.entity.Restaurant;
import hu.university.etelprojekt.etelprojekt.service.RestaurantService;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/")
    public String showRestaurants(Model model) {
        logger.info("Metódus indult");
        try {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            model.addAttribute("restaurants", restaurants);
        } catch (Exception e) {
            logger.error("Hiba történt az éttermek lekérdezése során", e);
        }
        return "index"; // Visszatér a Thymeleaf index sablonhoz
    }
    

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "Pages/cart";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "Pages/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "Pages/register";
    }

    @GetMapping("/order")
    public String showOrderPage() {
        return "Pages/order";
    }

    @GetMapping("/profile")
    public String showProfilePage() {
        return "Pages/profile";
    }

    @GetMapping("/dashboard")
    public String showDashboardPage() {
        return "Pages/dashboard";
    }

    @GetMapping("/adminOrders")
    public String showAdminOrdersPage() {
        return "Pages/adminOrders";
    }

    @GetMapping("/employees")
    public String showEmployeesPage() {
        return "Pages/employees";
    }

    @GetMapping("/endUsers")
    public String showEndUsersPage() {
        return "Pages/endUsers";
    }

    @GetMapping("/categories")
    public String showCategoriesPage() {
        return "Pages/categories";
    }

    @GetMapping("/favorites")
    public String showFavoritesPage() {
        return "Pages/favorites";
    }

    @GetMapping("/earlierOrders")
    public String showEarlierOrdersPage() {
        return "Pages/earlierOrders";
    }

    @GetMapping("/city")
    public String showCityPage() {
        return "Pages/city";
    }

    @GetMapping("/restaurant")
    public String showRestaurantPage() {
        return "Pages/restaurant";
    }
}