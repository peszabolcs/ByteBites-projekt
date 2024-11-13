package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /*
     * // Find category by category name
     * Optional<Category> findByCategoryName(String categoryName);
     */

}
