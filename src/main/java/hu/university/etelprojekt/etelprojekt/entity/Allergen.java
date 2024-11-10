package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "allergens")
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allergen_id")
    private Long allergenId;

    @Column(name = "allergen_name", nullable = false, unique = true)
    private AllergenType allergenName;

    @Column(name = "allergen_name_hungarian", nullable = false)
    private String allergenNameHungarian;

    // Getters and Setters
    public Long getAllergenId() {
        return allergenId;
    }

    public void setAllergenId(Long allergenId) {
        this.allergenId = allergenId;
    }

    public AllergenType getAllergenName() {
        return allergenName;
    }

    public void setAllergenName(AllergenType allergenName) {
        this.allergenName = allergenName;
        this.allergenNameHungarian = allergenName.getAllergenNameHungarian(); // Set Hungarian name automatically
    }

    public String getAllergenNameHungarian() {
        return allergenNameHungarian;
    }

    public void setAllergenNameHungarian(String allergenNameHungarian) {
        this.allergenNameHungarian = allergenNameHungarian;
    }
}
