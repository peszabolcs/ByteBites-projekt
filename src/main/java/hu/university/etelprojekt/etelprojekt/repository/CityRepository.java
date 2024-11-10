package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    // Find a city by its ID
    Optional<City> findById(Long cityId);

    // Find all cities by category ID (example: get all cities for a particular
    // category)
    List<City> findByCategoryId(Long categoryId);

    // Find a city by its name (example: used for searching a city)
    Optional<City> findByCityName(String cityName);

    // Custom query: Get all cities and their associated categories
    @Query("SELECT c FROM City c JOIN FETCH c.category WHERE c.cityId = :cityId")
    Optional<City> findCityWithCategory(@Param("cityId") Long cityId);

    // Custom query to delete a city by ID
    void deleteById(Long cityId);

    // Custom query to get all cities by category ID
    @Query("SELECT c FROM City c WHERE c.category.categoryId = :categoryId")
    List<City> findCitiesByCategory(@Param("categoryId") Long categoryId);
}
