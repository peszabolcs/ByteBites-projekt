package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Find category by ID
    Optional<Category> findById(Long categoryId);

    // Find category by name
    Optional<Category> findByCategoryName(String categoryName);

    // Save or update category
    @SuppressWarnings("unchecked")
    Category save(Category category);

    // Delete category by ID
    void deleteById(Long categoryId);

    // Find all categories sorted by name
    @Query("SELECT c FROM Category c ORDER BY c.categoryName ASC")
    List<Category> findAllCategoriesSortedByName();

    // Count categories
    @Query("SELECT COUNT(c) FROM Category c")
    long countCategories();

    // Find categories by name containing a keyword
    @Query("SELECT c FROM Category c WHERE c.categoryName LIKE %:name%")
    List<Category> findCategoriesByNameContains(@Param("name") String name);

    // Find categories by name and description
    @Query("SELECT c FROM Category c WHERE c.categoryName LIKE %:name% AND c.description LIKE %:description%")
    List<Category> findCategoriesByNameAndDescription(@Param("name") String name,
            @Param("description") String description);

    // Case-insensitive search by name
    @Query("SELECT c FROM Category c WHERE LOWER(c.categoryName) = LOWER(:name)")
    Optional<Category> findCategoryByNameIgnoreCase(@Param("name") String name);

    // Delete category by name
    @Modifying
    @Query("DELETE FROM Category c WHERE c.categoryName = :name")
    void deleteCategoryByName(@Param("name") String name);

    // Update category name by ID
    @Modifying
    @Query("UPDATE Category c SET c.categoryName = :categoryName WHERE c.categoryId = :categoryId")
    void updateCategoryNameById(@Param("categoryId") Long categoryId, @Param("categoryName") String categoryName);

}
