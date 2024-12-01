package hu.university.etelprojekt.etelprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hu.university.etelprojekt.etelprojekt.entity.CartItems;
import hu.university.etelprojekt.etelprojekt.entity.OrderItemsId;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, OrderItemsId> {

    // Find all order items for a specific order
    List<CartItems> findByOrder_OrderId(Long orderId);

    // Find all order items for a specific dish
    List<CartItems> findByDish_DishId(Long dishId);

    // Find all order items by quantity
    List<CartItems> findByQuantity(int quantity);

    // Find all order items by price
//    List<CartItems> findByPrice(BigDecimal price);

    // Find all order items for a specific order and dish
    // List<OrderItems> findByOrder_OrderIdAndDish_Dish_id(Long orderId, Long
    // dish_id);
    List<CartItems> findByOrder_OrderIdAndDish_DishId(Long orderId, Long dishId);

}
