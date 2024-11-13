package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    // Find all addresses by postal code
    List<Address> findByPostalCode(String postalCode);

    // Find all addresses by city
    List<Address> findByCity(String city);

    // Find all addresses by street name (corrected to match the field
    // 'street_name')
    List<Address> findByStreetName(String streetName);

    // Custom query: Find addresses by a combination of city and street name
    List<Address> findByCityAndStreetName(String city, String streetName);

}
