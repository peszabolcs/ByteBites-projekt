package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import hu.university.etelprojekt.etelprojekt.entity.CartItems;
import hu.university.etelprojekt.etelprojekt.entity.Dish;
import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Get all carts
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // Get cart by cart ID
    public Optional<Cart> getCartById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    // Get cart by user
    public Optional<Cart> getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    // Save or update a cart
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Delete a cart by user ID
    public void deleteCartByUserId(Long userId) {
        cartRepository.deleteByUser_UserId(userId);
    }

    // Check if a cart exists by user ID
    public boolean existsByUserId(Long userId) {
        return cartRepository.existsByUser_UserId(userId);
    }

    public void addDishToCart(User user, Dish dish) {
        System.out.println("Felhasználó: " + user);
        System.out.println("Étel: " + dish);

        if (user == null) {
            throw new IllegalArgumentException("A felhasználó nem lehet null.");
        }

        if (dish == null) {
            throw new IllegalArgumentException("Az étel nem lehet null.");
        }

        Optional<Cart> optionalCart = cartRepository.findByUser(user);
        Cart cart = optionalCart.orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            newCart.setCartItems(new ArrayList<>());
            newCart.setTotal_price(BigDecimal.ZERO);
            Cart savedCart = cartRepository.save(newCart);
            System.out.println("Új kosár létrehozva: " + savedCart);
            return savedCart;
        });

        List<CartItems> items = cart.getCartItems();
        CartItems existingItem = items.stream()
                .filter(item -> item.getDish().getDishId().equals(dish.getDishId()))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + 1);
            System.out.println("Már létező elem mennyisége növelve: " + existingItem);
        } else {
            CartItems newItem = new CartItems();
            newItem.setDish(dish);
            newItem.setQuantity(1);
            newItem.setCart(cart);
            newItem.setOrder(null);
            newItem.setPrice(BigDecimal.valueOf(dish.getPrice()));
            items.add(newItem);
            System.out.println("Új elem hozzáadva: " + newItem);
        }

        cartRepository.save(cart);
        System.out.println("Étel hozzáadva a kosárhoz " + cart.getCartItems());
    }
}
