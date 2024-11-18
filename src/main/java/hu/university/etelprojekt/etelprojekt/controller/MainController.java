package hu.university.etelprojekt.etelprojekt.controller;
import java.util.ArrayList;
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
        System.out.println("showRestaurants metódus kezdődik");
        try {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            System.out.println("Éttermek lekérdezve: " + (restaurants != null ? restaurants.size() : "null") + " db");
            
            if (restaurants == null || restaurants.isEmpty()) {
                System.out.println("Nincs étterem az adatbázisban");
                restaurants = new ArrayList<>();
            } else {
                System.out.println("Talált éttermek:");
                for (Restaurant r : restaurants) {
                    System.out.println(" - " + r.getRestaurantName() + " (ID: " + r.getRestaurantId() + ")");
                }
            }
            
            model.addAttribute("restaurants", restaurants);
            System.out.println("Model feltöltve");
            
        } catch (Exception e) {
            System.out.println("HIBA: " + e.getMessage());
            e.printStackTrace();
            model.addAttribute("restaurants", new ArrayList<>());
            model.addAttribute("error", "Nem sikerült betölteni az éttermeket");
        }
        return "index";
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