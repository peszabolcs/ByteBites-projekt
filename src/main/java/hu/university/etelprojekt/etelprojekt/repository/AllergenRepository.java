package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Allergen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {

    // Find allergen by ID
    @SuppressWarnings("null")
    Optional<Allergen> findById(Long allergen_id);

    // Find allergen by allergen name (enum value)
    Optional<Allergen> findByAllergenName(String allergen_name);

    // Save or update allergen (handled by JpaRepository)
    @SuppressWarnings({ "unchecked", "null" })
    Allergen save(Allergen allergen);

    // Delete allergen by ID
    void deleteById(@SuppressWarnings("null") Long allergen_id);

    // Check if allergen exists by name
    boolean existsByAllergenName(String allergen_name);

}
