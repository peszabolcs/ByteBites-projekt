package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.CartItems;
import hu.university.etelprojekt.etelprojekt.entity.OrderItemsId;
import hu.university.etelprojekt.etelprojekt.repository.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartItemsService {

    @Autowired
    private CartItemsRepository orderItemsRepository;

    // Find all items for a specific order
    public List<CartItems> findItemsByOrder(Long orderId) {
        return orderItemsRepository.findByOrder_OrderId(orderId);
    }

    // Find all items for a specific dish
    public List<CartItems> findItemsByDish(Long dishId) {
        return orderItemsRepository.findByDish_DishId(dishId);
    }

    // Find all items by quantity
    public List<CartItems> findItemsByQuantity(int quantity) {
        return orderItemsRepository.findByQuantity(quantity);
    }

    // Find all items by price
//    public List<CartItems> findItemsByPrice(BigDecimal price) {
//        return orderItemsRepository.findByPrice(price);
//    }

    // Find items by orderId and dishId
    public List<CartItems> findItemsByOrderAndDish(Long orderId, Long dishId) {
        return orderItemsRepository.findByOrder_OrderIdAndDish_DishId(orderId, dishId);
    }

    // Add an OrderItem to the database
    public CartItems saveOrderItem(CartItems orderItem) {
        return orderItemsRepository.save(orderItem);
    }

    // Remove an OrderItem
    public void deleteOrderItem(OrderItemsId id) {
        orderItemsRepository.deleteById(id);
    }
}
