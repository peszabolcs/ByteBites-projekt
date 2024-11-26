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

    @Override
    public String toString() {
        return "OrderItems [id=" + id + ", order=" + order + ", dish=" + dish + ", cart=" + cart + ", quantity="
                + quantity + ", price=" + price + "]";
    }
}