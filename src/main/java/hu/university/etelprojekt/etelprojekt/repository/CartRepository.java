package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Find a cart by its ID
    Optional<Cart> findById(Long cartId);

    // Find a cart by its user ID
    Optional<Cart> findByUserId(Long userId);

    // Delete a cart by its ID
    void deleteById(Long cartId);

    // Update the total price of a cart
    @Modifying
    @Query("UPDATE Cart c SET c.totalPrice = :totalPrice WHERE c.cartId = :cartId")
    void updateCartTotalPrice(@Param("cartId") Long cartId, @Param("totalPrice") Double totalPrice);

    // Find carts within a certain price range
    List<Cart> findByTotalPriceBetween(Double minPrice, Double maxPrice);

    // Find all carts for a specific user with a total price greater than a given
    // amount
    List<Cart> findByUserIdAndTotalPriceGreaterThan(Long userId, Double totalPrice);

    // Delete carts associated with a user
    void deleteByUserId(Long userId);
}
