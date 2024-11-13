package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import hu.university.etelprojekt.etelprojekt.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    // Find cart by user (assuming a user can have one cart)
    Optional<Cart> findByUser(User user);

    // Delete the cart by userId (when an order is placed or the cart is abandoned)
    void deleteByUser_UserId(Long userId);

    // Custom query: to check if a cart exists by user ID
    boolean existsByUser_UserId(Long userId);

    // Find cart by cartId
    @SuppressWarnings("null")
    Optional<Cart> findById(Long cartId);

    // Find cart by userId
    Optional<Cart> findByUser_UserId(Long userId);

}
