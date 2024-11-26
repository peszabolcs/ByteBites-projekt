package hu.university.etelprojekt.etelprojekt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long order_id;
    private Long dish_id;


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
