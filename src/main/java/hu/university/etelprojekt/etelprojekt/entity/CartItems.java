package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items") // Specify the table name if needed
public class CartItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="dish_id", referencedColumnName = "dish_id", nullable = false)
    private Dish dish;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = true)
    private Order order;

    @Column(name = "price", nullable = false)
    private BigDecimal price;
}