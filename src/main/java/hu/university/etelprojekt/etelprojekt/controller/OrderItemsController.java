package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.OrderItems;
import hu.university.etelprojekt.etelprojekt.entity.OrderItemsId;
import hu.university.etelprojekt.etelprojekt.service.OrderItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    // Get all order items for a specific order
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItems>> getOrderItemsByOrder(@PathVariable Long orderId) {
        List<OrderItems> items = orderItemsService.findItemsByOrder(orderId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Get all order items for a specific dish
    @GetMapping("/dish/{dishId}")
    public ResponseEntity<List<OrderItems>> getOrderItemsByDish(@PathVariable Long dishId) {
        List<OrderItems> items = orderItemsService.findItemsByDish(dishId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Get order items by quantity
    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<OrderItems>> getOrderItemsByQuantity(@PathVariable int quantity) {
        List<OrderItems> items = orderItemsService.findItemsByQuantity(quantity);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Get order items by price
    @GetMapping("/price/{price}")
    public ResponseEntity<List<OrderItems>> getOrderItemsByPrice(@PathVariable BigDecimal price) {
        List<OrderItems> items = orderItemsService.findItemsByPrice(price);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Create a new order item
    @PostMapping
    public ResponseEntity<OrderItems> createOrderItem(@RequestBody OrderItems orderItem) {
        OrderItems savedOrderItem = orderItemsService.saveOrderItem(orderItem);
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }

    // Delete an order item
    @DeleteMapping("/{orderId}/{dishId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long orderId, @PathVariable Long dishId) {
        OrderItemsId orderItemsId = new OrderItemsId(orderId, dishId);
        orderItemsService.deleteOrderItem(orderItemsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
