package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.OrderItems;
import hu.university.etelprojekt.etelprojekt.entity.OrderItemsId;
import hu.university.etelprojekt.etelprojekt.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    // Find all items for a specific order
    public List<OrderItems> findItemsByOrder(Long orderId) {
        return orderItemsRepository.findByOrder_OrderId(orderId);
    }

    // Find all items for a specific dish
    public List<OrderItems> findItemsByDish(Long dishId) {
        return orderItemsRepository.findByDish_DishId(dishId);
    }

    // Find all items by quantity
    public List<OrderItems> findItemsByQuantity(int quantity) {
        return orderItemsRepository.findByQuantity(quantity);
    }

    // Find all items by price
    public List<OrderItems> findItemsByPrice(BigDecimal price) {
        return orderItemsRepository.findByPrice(price);
    }

    // Find items by orderId and dishId
    public List<OrderItems> findItemsByOrderAndDish(Long orderId, Long dishId) {
        return orderItemsRepository.findByOrder_OrderIdAndDish_DishId(orderId, dishId);
    }

    // Add an OrderItem to the database
    public OrderItems saveOrderItem(OrderItems orderItem) {
        return orderItemsRepository.save(orderItem);
    }

    // Remove an OrderItem
    public void deleteOrderItem(OrderItemsId id) {
        orderItemsRepository.deleteById(id);
    }
}
