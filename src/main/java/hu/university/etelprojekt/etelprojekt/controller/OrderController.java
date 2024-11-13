package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Order;
import hu.university.etelprojekt.etelprojekt.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create or update an order
    @PostMapping
    public ResponseEntity<Order> createOrUpdateOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    // Get an order by its ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> order = orderService.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all orders for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    // Get all orders placed on a specific date
    @GetMapping("/date/{orderDate}")
    public ResponseEntity<List<Order>> getOrdersByDate(@PathVariable java.sql.Date orderDate) {
        List<Order> orders = orderService.getOrdersByDate(orderDate);
        return ResponseEntity.ok(orders);
    }

    // Get orders by total amount
    @GetMapping("/totalAmount/{totalAmount}")
    public ResponseEntity<List<Order>> getOrdersByTotalAmount(@PathVariable Double totalAmount) {
        List<Order> orders = orderService.getOrdersByTotalAmount(totalAmount);
        return ResponseEntity.ok(orders);
    }

    // Update an existing order
    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        if (!orderService.getOrderById(orderId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        order.setOrderId(orderId);
        Order updatedOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // Delete an order by its ID
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        if (!orderService.getOrderById(orderId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
