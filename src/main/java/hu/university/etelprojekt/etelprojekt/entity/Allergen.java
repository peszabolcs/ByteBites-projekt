package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "allergens") // Optional: specify the table name in the database
public class Allergen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the allergenId (primary key)
    private Long allergenId;

    private String allergenName; // Store the allergen name directly as a String

    // Default constructor
    public Allergen() {
    }

    // Constructor with all fields
    public Allergen(Long allergenId, String allergenName) {
        this.allergenId = allergenId;
        this.allergenName = allergenName;
    }

    // Getters and Setters
    public Long getAllergenId() {
        return allergenId;
    }

    public void setAllergenId(Long allergenId) {
        this.allergenId = allergenId;
    }

    public String getAllergenName() {
        return allergenName;
    }

    public void setAllergenName(String allergenName) {
        this.allergenName = allergenName;
    }

    @Override
    public String toString() {
        return "Allergen [allergenId=" + allergenId + ", allergenName=" + allergenName + "]";
    }
}
