package hu.university.etelprojekt.etelprojekt.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemsId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long order_id;
    private Long dish_id;

    // Default constructor
    public OrderItemsId() {
    }

    // Constructor with all fields
    public OrderItemsId(Long order_id, Long dish_id) {
        this.order_id = order_id;
        this.dish_id = dish_id;
    }

    // Getters and Setters
    public Long getOrderId() {
        return order_id;
    }

    public void setOrderId(Long orderId) {
        this.order_id = orderId;
    }

    public Long getDishId() {
        return dish_id;
    }

    public void setDishId(Long dishId) {
        this.dish_id = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OrderItemsId that = (OrderItemsId) o;
        return Objects.equals(order_id, that.order_id) &&
                Objects.equals(dish_id, that.dish_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, dish_id);
    }

    @Override
    public String toString() {
        return "OrderItemsId [orderId=" + order_id + ", dishId=" + dish_id + "]";
    }
}
