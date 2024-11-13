package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items") // Specify the table name if needed
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemsId id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "dish_id", insertable = false, updatable = false)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", insertable = false, updatable = false)
    private Cart cart;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private BigDecimal price;

    // Default constructor
    public OrderItems() {
    }

    // Constructor with all fields
    public OrderItems(OrderItemsId id, Order order, Dish dish, Cart cart, int quantity, BigDecimal price) {
        this.id = id;
        this.order = order;
        this.dish = dish;
        this.cart = cart;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public OrderItemsId getId() {
        return id;
    }

    public void setId(OrderItemsId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItems [id=" + id + ", order=" + order + ", dish=" + dish + ", cart=" + cart + ", quantity="
                + quantity + ", price=" + price + "]";
    }
}