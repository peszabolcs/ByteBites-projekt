package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "allergens") // Optional: specify the table name in the database
public class Allergen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the allergenId (primary key)
    private Long allergenId;
    private String allergenName;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Restaurant> restaurants;

    @Override
    public String toString() {
        return "Allergen [allergenId=" + allergenId + ", allergenName=" + allergenName + "]";
    }
}
