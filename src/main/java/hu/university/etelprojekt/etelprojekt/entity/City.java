package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "city") // Optional: specify the table name in the database
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the cityId (primary key)
    private Long city_id;

    private String cityName;

    @ManyToOne // Assuming a Many-to-One relationship with Category
    @JoinColumn(name = "category_id")
    private Category category;

    // Default constructor
    public City() {
    }

    // Constructor with all fields
    public City(Long cityId, String cityName, Category category) {
        this.city_id = cityId;
        this.cityName = cityName;
        this.category = category;
    }

    // Getters and Setters
    public Long getCityId() {
        return city_id;
    }

    public void setCityId(Long cityId) {
        this.city_id = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "City [cityId=" + city_id + ", cityName=" + cityName + ", category=" + category + "]";
    }
}
