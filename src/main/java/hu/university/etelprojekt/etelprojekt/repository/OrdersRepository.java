package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

    // Example queries (commented out for now, based on your needs):
    // Find an order by its status (e.g., "Pending", "Completed")
    // Optional<Order> findByOrderStatus(String orderStatus);

    // Find all orders for a specific user by user ID
    List<Order> findByUser_UserId(Long userId);

    // Find all orders placed on a specific date
    List<Order> findByOrderDate(java.sql.Date orderDate);

    // Find an order by its delivery time
    Optional<Order> findByDeliveryTime(java.sql.Time deliveryTime);

    // Find orders by total amount
    List<Order> findByTotalAmount(Double totalAmount);

    // Find orders by user ID and order status
    // List<Order> findByUser_IdAndOrderStatus(Long userId, String orderStatus);

}