package hu.university.etelprojekt.etelprojekt.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
        public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("isAuthenticated", true);
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "index"; // Ellenőrizd, hogy ez a helyes sablonnév-e
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
}