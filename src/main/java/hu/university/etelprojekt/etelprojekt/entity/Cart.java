package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carts") // Optional: specify the table name in the database
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the cartId (primary key)
    private Long cart_id;

    private BigDecimal total_price;

    @ManyToOne // One user can have many carts, but each cart belongs to one user
    private User user;

    @OneToMany // A cart can contain many order items
    private List<OrderItems> orderItems;

    @OneToOne // A cart has a one-to-one relationship with an order
    private Order order;

    // Default constructor
    public Cart() {
    }

    // Constructor with all fields
    public Cart(Long cartId, BigDecimal total_price, User user, List<OrderItems> orderItems, Order order) {
        this.cart_id = cartId;
        this.total_price = total_price;
        this.user = user;
        this.orderItems = orderItems;
        this.order = order;
    }

    // Getters and Setters
    public Long getCartId() {
        return cart_id;
    }

    public void setCartId(Long cartId) {
        this.cart_id = cartId;
    }

    public BigDecimal getTotalPrice() {
        return total_price;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.total_price = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cart_id + ", totalPrice=" + total_price + ", user=" + user + ", orderItems="
                + orderItems
                + ", order=" + order + "]";
    }
}
