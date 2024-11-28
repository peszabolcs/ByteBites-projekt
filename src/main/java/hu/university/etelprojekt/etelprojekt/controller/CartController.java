package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.service.CartService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Get all carts
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }

    // Get cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Optional<Cart> cart = cartService.getCartById(id);
        return cart.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get cart by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
        Optional<Cart> cart = cartService
                .getCartByUser(new User(userId)); // Assuming a constructor in User that takes ID
                                                                                                        // User
                                                                                                        // constructor
                                                                                                        // that takes ID
        return cart.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update a cart
    @PostMapping
    public ResponseEntity<Cart> createOrUpdateCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.saveCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    // Delete cart by user ID
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteCartByUserId(@PathVariable Long userId) {
        cartService.deleteCartByUserId(userId);
        return ResponseEntity.noContent().build();
    }

    // Check if a cart exists by user ID
    @GetMapping("/exists/user/{userId}")
    public ResponseEntity<Boolean> cartExistsByUserId(@PathVariable Long userId) {
        boolean exists = cartService.existsByUserId(userId);
        return ResponseEntity.ok(exists);
    }
}
