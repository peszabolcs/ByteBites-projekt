package hu.university.etelprojekt.etelprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.university.etelprojekt.etelprojekt.entity.Order;
import hu.university.etelprojekt.etelprojekt.entity.OrderItems;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<Order, Long> {

    // Find all order items by order ID
    List<OrderItems> findByOrderId(Long orderId);

    // Find all order items by dish ID
    List<OrderItems> findByDishId(Long dishId);

    // Find order items by order ID and dish ID
    OrderItems findByOrderIdAndDishId(Long orderId, Long dishId);

    // Custom query to get order items with price details for an order
    @Query("SELECT oi FROM OrderItem oi WHERE oi.orderId = :orderId")
    List<OrderItems> findOrderItemsWithPrice(@Param("orderId") Long orderId);
}
