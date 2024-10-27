package hu.university.etelprojekt.etelprojekt.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cssFile", "style.css");
        model.addAttribute("pageTitle", "BYTEBITES - Kezdőlap");
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
}