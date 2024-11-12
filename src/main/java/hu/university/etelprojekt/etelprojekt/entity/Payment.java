package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment") // Specify the table name if necessary
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long payment_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Assuming Order is another entity
    private Order order_id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "payment_date")
    private String payment_date;

    @Column(name = "status")
    private String status;

    // Default constructor
    public Payment() {
    }

    // Constructor with all fields
    public Payment(Long paymentId, Order order, Double amount, String paymentMethod, String paymentDate,
            String status) {
        this.payment_id = paymentId;
        this.order_id = order;
        this.amount = amount;
        this.payment_method = paymentMethod;
        this.payment_date = paymentDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getPaymentId() {
        return payment_id;
    }

    public void setPaymentId(Long paymentId) {
        this.payment_id = paymentId;
    }

    public Order getOrder() {
        return order_id;
    }

    public void setOrder(Order order) {
        this.order_id = order;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return payment_method;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.payment_method = paymentMethod;
    }

    public String getPaymentDate() {
        return payment_date;
    }

    public void setPaymentDate(String paymentDate) {
        this.payment_date = paymentDate;
    }

    public String getPaymentStatus() {
        return status;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.status = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + payment_id + ", order=" + order_id + ", amount=" + amount + ", paymentMethod="
                + payment_method + ", paymentDate=" + payment_date + ", paymentStatus=" + status + "]";
    }
}
