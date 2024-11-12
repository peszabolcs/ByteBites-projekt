package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Address;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Find an address by its ID (Read)
    @SuppressWarnings("null")
    Optional<Address> findById(Long address_id);

    // Find an address by postal code (optional)
    Optional<Address> findByPostalCode(String postal_code);

    // Create or update an address (Save/Update)
    // This is automatically handled by the save() method in JpaRepository

    // Delete an address by ID (Delete)
    void deleteById(@SuppressWarnings("null") Long address_id);

    // Update address fields like postal code, city, street name, etc.
    @Modifying
    @Query("UPDATE Address a SET a.postal_code = :postal_code, a.city = :city, a.street_name = :street_name, a.house_number = :house_number, a.building = :building, a.staircase = :staircase, a.floor = :floor, a.door = :door WHERE a.address_id = :address_id")
    void updateAddress(@Param("address_id") Long address_id,
            @Param("postal_code") String postal_code,
            @Param("city") String city,
            @Param("street_name") String street_name,
            @Param("house_number") String house_number,
            @Param("building") String building,
            @Param("staircase") String staircase,
            @Param("floor") String floor,
            @Param("door") String door);

    // Custom method to check if an address exists by postal code (optional)
    boolean existsByPostalCode(String postal_code);
}
