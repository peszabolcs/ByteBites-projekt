package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menu_id;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @OneToMany(mappedBy = "menu")
    private List<Dish> dishes;

    // Default constructor
    public Menu() {
    }

    // Constructor with all fields
    public Menu(Long menuId, String menuName, List<Dish> dishes) {
        this.menu_id = menuId;
        this.menuName = menuName;
        this.dishes = dishes;
    }

    // Getters and Setters
    public Long getMenuId() {
        return menu_id;
    }

    public void setMenuId(Long menuId) {
        this.menu_id = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu [menuId=" + menu_id + ", menuName=" + menuName + ", dishes=" + dishes + "]";
    }
}
