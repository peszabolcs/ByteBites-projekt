package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import jakarta.transaction.Transactional;

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
    @SuppressWarnings("null")
    Optional<Cart> findById(Long cart_id);

    // Find a cart by its user ID
    Optional<Cart> findByUserId(Long user_id);

    // Delete a cart by its ID
    void deleteById(@SuppressWarnings("null") Long cart_id);

    // Update the total price of a cart
    @Modifying
    @Transactional
    @Query("UPDATE Cart c SET c.total_price = :total_price WHERE c.cart_id = :cart_id")
    void updateCartTotalPrice(@Param("cart_id") Long cart_id, @Param("total_price") Double total_price);

    // Find carts within a certain price range
    List<Cart> findByTotalPriceBetween(Double minPrice, Double maxPrice);

    // Find all carts for a specific user with a total price greater than a given
    // amount
    List<Cart> findByUserIdAndTotalPriceGreaterThan(Long user_id, Double total_price);

    // Delete carts associated with a user
    void deleteByUserId(Long user_id);
}
