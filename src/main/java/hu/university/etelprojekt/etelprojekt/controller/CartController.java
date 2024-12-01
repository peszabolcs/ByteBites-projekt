package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.CartItemDTO;
import hu.university.etelprojekt.etelprojekt.entity.CartItems;
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

    @GetMapping("/items")
    public ResponseEntity<List<CartItemDTO>> getCartItems(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return ResponseEntity.status(401).build();
        }

        User sessionUser = (User) session.getAttribute("user");
        List<CartItemDTO> cartItemDTOs = cartService.getCartByUser(sessionUser)
                .map(cart -> cart.getCartItems().stream()
                        .map(CartItemDTO::fromEntity)
                        .toList())
                .orElse(new ArrayList<>());

        return ResponseEntity.ok(cartItemDTOs);
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
