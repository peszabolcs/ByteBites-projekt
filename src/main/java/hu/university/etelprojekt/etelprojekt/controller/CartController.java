package hu.university.etelprojekt.etelprojekt.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(HttpServletRequest request, @RequestBody String itemName) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return ResponseEntity.status(401).body("Bejelentkezés szükséges.");
        }

        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        cart.add(itemName);
        return ResponseEntity.ok("Hozzáadva a kosárhoz: " + itemName);
    }

    @GetMapping
    public ResponseEntity<List<String>> viewCart(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return ResponseEntity.status(401).body(null);
        }

        List<String> cart = (List<String>) session.getAttribute("cart");
        return ResponseEntity.ok(cart != null ? cart : new ArrayList<>());
    }
}
