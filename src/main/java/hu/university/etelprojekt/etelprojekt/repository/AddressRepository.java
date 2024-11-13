package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    /*
     * // Custom query methods (optional):
     * 
     * // Find addresses by postal code
     * List<Address> findByPostalCode(String postalCode);
     * 
     * // Find addresses by city
     * List<Address> findByCity(String city);
     * 
     * // Find addresses by street name
     * List<Address> findByStreetName(String streetName);
     */
}
