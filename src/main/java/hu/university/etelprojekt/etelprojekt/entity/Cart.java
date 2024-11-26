package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carts") // Optional: specify the table name in the database
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the cartId (primary key)
    @Column(name = "cart_id")
    private Long cart_id;

    @Column(name = "total_price", nullable = false)
    private BigDecimal total_price;

    @Column(name = "user_id", nullable = false)
    private User user_id;

    @ManyToOne // One user can have many carts, but each cart belongs to one user
    private User user;

    @OneToMany // A cart can contain many order items
    private List<OrderItems> orderItems;

    @OneToOne // A cart has a one-to-one relationship with an order
    private Order order;

    @Override
    public String toString() {
        return "Cart [cartId=" + cart_id + ", totalPrice=" + total_price + ", user=" + user + ", orderItems="
                + orderItems
                + ", order=" + order + "]";
    }
}
