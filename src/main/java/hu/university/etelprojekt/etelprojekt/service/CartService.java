package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.repository.CartRepository;
import org.springframework.stereotype.Service;

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
}
