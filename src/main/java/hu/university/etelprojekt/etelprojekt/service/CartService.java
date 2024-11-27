package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Cart;
import hu.university.etelprojekt.etelprojekt.entity.Dish;
import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final List<Dish> cart = new ArrayList<>();

    public void addDishToCart(Dish dish) {
        cart.add(dish);
    }

    public List<Dish> getCart() {
        return cart;
    }
}
