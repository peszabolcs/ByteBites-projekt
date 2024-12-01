package hu.university.etelprojekt.etelprojekt.entity;

import hu.university.etelprojekt.etelprojekt.entity.CartItems;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartItemDTO {
    private Long orderItemId;
    private String dishName;
    private int quantity;
    private BigDecimal price;

    public static CartItemDTO fromEntity(CartItems item) {
        System.out.println("Dish: " + (item.getDish() != null ? item.getDish().getName() : "null"));
        return CartItemDTO.builder()
                .orderItemId(item.getOrderItemId())
                .dishName(item.getDish() != null && item.getDish().getName() != null ? item.getDish().getName() : "Ismeretlen étel")
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
    }

}
