package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import hu.university.etelprojekt.etelprojekt.entity.Dish;
import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.service.CartService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin(origins = "http://localhost:8080")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestBody Dish dish) {
        cartService.addDishToCart(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dish added to cart");
    }
}
