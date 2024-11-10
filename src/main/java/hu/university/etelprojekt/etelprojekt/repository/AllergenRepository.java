package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Allergen;
import hu.university.etelprojekt.etelprojekt.entity.AllergenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {

    // Find allergen by ID
    Optional<Allergen> findById(Long allergenId);

    // Find allergen by allergen name (enum value)
    Optional<Allergen> findByAllergenName(AllergenType allergenName);

    // Save or update allergen (handled by JpaRepository)
    @SuppressWarnings("unchecked")
    Allergen save(Allergen allergen);

    // Delete allergen by ID
    void deleteById(Long allergenId);

    // Check if allergen exists by name
    boolean existsByAllergenName(AllergenType allergenName);

}
