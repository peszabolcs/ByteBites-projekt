package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by email
    Optional<User> findByEmail(String email);

    // Find a user by first name and last name
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

    // Find a user by their user type (e.g., admin, customer, etc.)
    Optional<User> findByUserType(String userType);

    // Find a user by phone number
    Optional<User> findByPhoneNumber(String phoneNumber);

    // Find a user by their address (assuming user_address relationship)
    Optional<User> findByAddress_City(String city);
}
