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
    

    // @GetMapping("/cart")
    // public String cart(Model model) {
    //     model.addAttribute("cssFile", "cart.css"); // A kosár oldal saját CSS fájlja
    //     model.addAttribute("pageTitle", "BYTEBITES - Kosár");
    //     return "cart"; // A Thymeleaf automatikusan a templates mappából tölti be
    // }

    @GetMapping("/cart")
    public String cartPage() {
        return "Pages/cart"; // Így a "templates/Pages/cart.html" fájlt tölti be
    }
}