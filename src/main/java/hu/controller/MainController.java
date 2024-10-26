package hu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index"; // A Thymeleaf automatikusan a templates mappából tölti be
    }
}
