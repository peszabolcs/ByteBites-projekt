package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItems> cartItems;

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", deliveryTime=" + deliveryTime + ", systemUsageFee=" + systemUsageFee +
                ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", user="
                + user + "]";
    }
}
