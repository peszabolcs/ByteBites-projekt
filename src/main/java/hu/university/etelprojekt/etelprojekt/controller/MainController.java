package hu.university.etelprojekt.etelprojekt.controller;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hu.university.etelprojekt.etelprojekt.entity.Restaurant;
import hu.university.etelprojekt.etelprojekt.service.RestaurantService;

@Controller
@Slf4j
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/")
    public String showRestaurants(Model model) {
        log.info("GetshowRestaurants method called " + model.toString());
        try {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            
            if (restaurants == null || restaurants.isEmpty()) {
                log.info("Not found Restaurants in DB: ");
                restaurants = new ArrayList<>();
            } else {
                log.info("Found Restaurants count: " + restaurants.size());
                for (Restaurant r : restaurants) {
                    System.out.println(" - " + r.getRestaurantName() + " (ID: " + r.getRestaurantId() + ")");
                }
            }
            
            model.addAttribute("restaurants", restaurants);            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("restaurants", new ArrayList<>());
            model.addAttribute("error", "Unable to load the restaurants");
        }
        return "index";
    }
    
    

    @GetMapping("/index")
    public String indexPage(Model model) {
        return showRestaurants(model);
    }

//    @GetMapping("/cart")
//    public String cartPage() {
//        return "Pages/cart";
//    }

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