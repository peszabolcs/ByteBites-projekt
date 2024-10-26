package hu.university.etelprojekt.etelprojekt.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class StaticResourceController {
    @GetMapping("/css/style.css")
    public String serveCss() {
        return "redirect:/css/style.css";
    }
}
