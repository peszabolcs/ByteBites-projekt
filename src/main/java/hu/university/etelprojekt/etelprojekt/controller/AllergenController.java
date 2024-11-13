package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Allergen;
import hu.university.etelprojekt.etelprojekt.service.AllergenService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/allergens")
public class AllergenController {

    private final AllergenService allergenService;

    public AllergenController(AllergenService allergenService) {
        this.allergenService = allergenService;
    }

    // Get all allergens
    @GetMapping
    public ResponseEntity<List<Allergen>> getAllAllergens() {
        List<Allergen> allergens = allergenService.getAllergens();
        return ResponseEntity.ok(allergens);
    }

    // Get allergen by ID
    @GetMapping("/{id}")
    public ResponseEntity<Allergen> getAllergenById(@PathVariable Long id) {
        Optional<Allergen> allergen = allergenService.getAllergenById(id);
        return allergen.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update an allergen
    @PostMapping
    public ResponseEntity<Allergen> createOrUpdateAllergen(@RequestBody Allergen allergen) {
        Allergen savedAllergen = allergenService.saveAllergen(allergen);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAllergen);
    }

    // Delete allergen by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllergen(@PathVariable Long id) {
        allergenService.deleteAllergen(id);
        return ResponseEntity.noContent().build();
    }
}
