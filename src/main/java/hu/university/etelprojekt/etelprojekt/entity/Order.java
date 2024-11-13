package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "orders") // Specify the table name if necessary
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // This field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "delivery_time")
    private LocalTime deliveryTime;

    @Column(name = "system_usage_fee")
    private BigDecimal systemUsageFee;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItems> orderItems;

    // Default constructor
    public Order() {
    }

    // Constructor with all fields
    public Order(Long orderId, LocalTime deliveryTime, BigDecimal systemUsageFee, String orderStatus,
            LocalDate orderDate, BigDecimal totalAmount, User user, List<OrderItems> orderItems) {
        this.orderId = orderId;
        this.deliveryTime = deliveryTime;
        this.systemUsageFee = systemUsageFee;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
        this.orderItems = orderItems;
    }

    // Constructor without orderId (optional)
    public Order(LocalTime deliveryTime, BigDecimal systemUsageFee, String orderStatus,
            LocalDate orderDate, BigDecimal totalAmount, User user, List<OrderItems> orderItems) {
        this.deliveryTime = deliveryTime;
        this.systemUsageFee = systemUsageFee;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
        this.orderItems = orderItems;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public BigDecimal getSystemUsageFee() {
        return systemUsageFee;
    }

    public void setSystemUsageFee(BigDecimal systemUsageFee) {
        this.systemUsageFee = systemUsageFee;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", deliveryTime=" + deliveryTime + ", systemUsageFee=" + systemUsageFee +
                ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", user="
                + user + "]";
    }
}
