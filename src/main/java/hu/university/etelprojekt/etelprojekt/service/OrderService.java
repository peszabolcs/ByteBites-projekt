package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Order;
import hu.university.etelprojekt.etelprojekt.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    // Save a new order or update an existing one
    public Order saveOrder(Order order) {
        return ordersRepository.save(order);
    }

    // Get an order by its ID
    public Optional<Order> getOrderById(Long orderId) {
        return ordersRepository.findById(orderId);
    }

    // Get all orders for a specific user
    public List<Order> getOrdersByUserId(Long userId) {
        return ordersRepository.findByUser_UserId(userId);
    }

    // Get all orders placed on a specific date
    public List<Order> getOrdersByDate(java.sql.Date orderDate) {
        return ordersRepository.findByOrderDate(orderDate);
    }

    // Get orders by total amount
    public List<Order> getOrdersByTotalAmount(Double totalAmount) {
        return ordersRepository.findByTotalAmount(totalAmount);
    }

    // Update an existing order (if necessary)
    public Order updateOrder(Order order) {
        return ordersRepository.save(order);
    }

    // Delete an order by its ID
    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }
}
