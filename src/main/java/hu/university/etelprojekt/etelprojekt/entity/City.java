package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city") // Optional: specify the table name in the database
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the cityId (primary key)
    private Long city_id;

    private String cityName;

    @Getter
    @Setter
    @ManyToOne // Assuming a Many-to-One relationship with Category
    @JoinColumn(name = "category_id")
    private Category category;


    @Override
    public String toString() {
        return "City [cityId=" + city_id + ", cityName=" + cityName + ", category=" + category + "]";
    }
}
