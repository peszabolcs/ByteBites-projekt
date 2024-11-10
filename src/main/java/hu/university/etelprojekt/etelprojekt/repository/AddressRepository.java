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
    Optional<Address> findById(Long addressId);

    // Find an address by postal code (optional)
    Optional<Address> findByPostalCode(String postalCode);

    // Create or update an address (Save/Update)
    // This is automatically handled by the save() method in JpaRepository

    // Delete an address by ID (Delete)
    void deleteById(Long addressId);

    // Update address fields like postal code, city, street name, etc.
    @Modifying
    @Query("UPDATE Address a SET a.postalCode = :postalCode, a.city = :city, a.streetName = :streetName, a.houseNumber = :houseNumber, a.building = :building, a.staircase = :staircase, a.floor = :floor, a.door = :door WHERE a.addressId = :addressId")
    void updateAddress(@Param("addressId") Long addressId,
            @Param("postalCode") String postalCode,
            @Param("city") String city,
            @Param("streetName") String streetName,
            @Param("houseNumber") String houseNumber,
            @Param("building") String building,
            @Param("staircase") String staircase,
            @Param("floor") String floor,
            @Param("door") String door);

    // Custom method to check if an address exists by postal code (optional)
    boolean existsByPostalCode(String postalCode);
}
