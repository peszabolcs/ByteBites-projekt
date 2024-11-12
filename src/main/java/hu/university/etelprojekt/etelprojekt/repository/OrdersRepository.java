package hu.university.etelprojekt.etelprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.university.etelprojekt.etelprojekt.entity.Order;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Long> {

    // Find all orders by user
    List<Order> findByUserId(Long user_id);

    // Find all orders by order status
    List<Order> findByOrderStatus(String orderStatus);

    // Find all orders within a date range
    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Order> findOrdersInDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);

    // Find order by order ID
    Order findByOrderId(Long orderId);
}
