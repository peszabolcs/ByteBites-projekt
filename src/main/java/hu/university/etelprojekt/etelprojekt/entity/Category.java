package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories") // Optional: specify the table name in the database
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the categoryId (primary key)
    private Long category_id;
    private String categoryName;
    private String pictureUrl;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Restaurant> restaurants;

    @Override
    public String toString() {
        return "Category [categoryId=" + category_id + ", categoryName=" + categoryName + ", pictureUrl=" + pictureUrl
                + "]";
    }
}
