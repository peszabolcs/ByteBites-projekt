package hu.university.etelprojekt.etelprojekt.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cssFile", "style.css"); // Az index oldal saját CSS fájlja
        model.addAttribute("pageTitle", "BYTEBITES - Kezdőlap");
        return "index"; // A Thymeleaf automatikusan a templates mappából tölti be
    }
    

    @GetMapping("/index")
    public String indexPage() {
        return "index"; // Az index.html betöltése a templates mappából
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "Pages/cart"; // Így a "templates/Pages/cart.html" fájlt tölti be
    }

    @GetMapping("/login")
    public String loginPage() {
        return "Pages/login"; // Így a "templates/Pages/login.html" fájlt tölti be
    }

    @GetMapping("/register")
    public String registerPage() {
        return "Pages/register"; // Így a "templates/Pages/register.html" fájlt tölti be
    }
}