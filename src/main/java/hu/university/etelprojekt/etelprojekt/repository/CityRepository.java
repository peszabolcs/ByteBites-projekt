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
    @SuppressWarnings("null")
    Optional<City> findById(Long city_id);

    // Find all cities by category ID (example: get all cities for a particular
    // category)
    List<City> findByCategoryId(Long category_id);

    // Find a city by its name (example: used for searching a city)
    Optional<City> findByCityName(String city_name);

    // Custom query: Get all cities and their associated categories
    @Query("SELECT c FROM City c JOIN FETCH c.category WHERE c.city_id = :city_id")
    Optional<City> findCityWithCategory(@Param("city_id") Long city_id);

    // Custom query to delete a city by ID
    void deleteById(@SuppressWarnings("null") Long city_id);

    // Custom query to get all cities by category ID
    @Query("SELECT c FROM City c WHERE c.category.category_id = :category_id")
    List<City> findCitiesByCategory(@Param("category_id") Long category_id);
}
