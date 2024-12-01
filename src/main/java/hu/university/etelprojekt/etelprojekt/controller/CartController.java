package hu.university.etelprojekt.etelprojekt.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import hu.university.etelprojekt.etelprojekt.entity.Dish;
import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.repository.DishRepository;
import hu.university.etelprojekt.etelprojekt.repository.UserRepository;
import hu.university.etelprojekt.etelprojekt.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {

    private final UserRepository userRepository;
    private final CartService cartService;
    private final DishRepository dishRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(HttpServletRequest request, @RequestParam Long dishId) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return ResponseEntity.status(401).body("Nincs bejelentkezve!");
        }

        User sessionUser = (User) session.getAttribute("user");
        Long sessionUserId = sessionUser.getUserId();

        System.out.println("Session userId: " + sessionUserId);
        System.out.println("Kapott dishId: " + dishId);

        try {
            cartService.addDishToCart(sessionUser, dishRepository.findById(dishId).orElseThrow());
            return ResponseEntity.ok("Sikeresen hozzáadva a kosárhoz!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



//    @GetMapping
//    public String viewCart(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            return "redirect:/login";
//        }
//        return "Pages/cart";
//    }
}
