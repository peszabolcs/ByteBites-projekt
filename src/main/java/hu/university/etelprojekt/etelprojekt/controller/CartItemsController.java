package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.CartItems;
import hu.university.etelprojekt.etelprojekt.entity.OrderItemsId;
import hu.university.etelprojekt.etelprojekt.service.CartItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class CartItemsController {

    @Autowired
    private CartItemsService orderItemsService;

    // Get all order items for a specific order
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<CartItems>> getOrderItemsByOrder(@PathVariable Long orderId) {
        List<CartItems> items = orderItemsService.findItemsByOrder(orderId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Get all order items for a specific dish
    @GetMapping("/dish/{dishId}")
    public ResponseEntity<List<CartItems>> getOrderItemsByDish(@PathVariable Long dishId) {
        List<CartItems> items = orderItemsService.findItemsByDish(dishId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Get order items by quantity
    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<CartItems>> getOrderItemsByQuantity(@PathVariable int quantity) {
        List<CartItems> items = orderItemsService.findItemsByQuantity(quantity);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Get order items by price
//    @GetMapping("/price/{price}")
//    public ResponseEntity<List<CartItems>> getOrderItemsByPrice(@PathVariable BigDecimal price) {
//        List<CartItems> items = orderItemsService.findItemsByPrice(price);
//        return new ResponseEntity<>(items, HttpStatus.OK);
//    }

    // Create a new order item
    @PostMapping
    public ResponseEntity<CartItems> createOrderItem(@RequestBody CartItems orderItem) {
        CartItems savedOrderItem = orderItemsService.saveOrderItem(orderItem);
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
