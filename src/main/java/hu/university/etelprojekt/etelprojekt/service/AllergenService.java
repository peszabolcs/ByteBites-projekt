package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Allergen;
import hu.university.etelprojekt.etelprojekt.repository.AllergenRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AllergenService {

    private final AllergenRepository allergenRepository;

    public AllergenService(AllergenRepository allergenRepository) {
        this.allergenRepository = allergenRepository;
    }

    // Get all allergens
    public List<Allergen> getAllergens() {
        return allergenRepository.findAll();
    }

    // Get allergen by ID
    public Optional<Allergen> getAllergenById(Long id) {
        return allergenRepository.findById(id);
    }

    // Save or update an allergen
    public Allergen saveAllergen(Allergen allergen) {
        return allergenRepository.save(allergen);
    }

    // Delete allergen by ID
    public void deleteAllergen(Long id) {
        allergenRepository.deleteById(id);
    }
}
