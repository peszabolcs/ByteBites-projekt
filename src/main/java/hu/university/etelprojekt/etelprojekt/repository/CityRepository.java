package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.City;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    /*
     * // Custom query methods can be added here as needed
     * 
     * // Example: Find cities by their category
     * List<City> findByCategory_CategoryId(Long categoryId);
     * 
     * // Example: Find a city by its name
     * City findByCityName(String cityName);
     */
}
