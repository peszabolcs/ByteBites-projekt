package hu.university.etelprojekt.etelprojekt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hu.university.etelprojekt.etelprojekt.entity.Address;
import hu.university.etelprojekt.etelprojekt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Save or update a user (CRUD operations are provided by JpaRepository)
    @SuppressWarnings({ "unchecked", "null" })
    User save(User user);

    // Find a user by email (useful for login, etc.)
    Optional<User> findByEmail(String email);

    // Find a user by their ID
    @SuppressWarnings("null")
    Optional<User> findById(Long user_id);

    // Method to find user by email and userType
    Optional<User> findByEmailAndUserType(String email, String userType);

    // Delete a user by their ID
    void deleteById(@SuppressWarnings("null") Long user_id);

    // Update user status (example of custom query method)
    @Modifying
    @Query("UPDATE User u SET u.status = :status WHERE u.user_id = :user_id")
    void updateUserStatus(@Param("user_id") Long user_id, @Param("status") String status);

    // Update user information (name, phone, address, etc.)
    @Modifying
    @Query("UPDATE User u SET u.first_name = :firstName, u.last_name = :lastName, u.phone_number = :phoneNumber, u.address = :address WHERE u.user_id = :user_id")
    void updateUserInfo(@Param("user_id") Long user_id,
            @Param("first_name") String first_name,
            @Param("last_name") String last_name,
            @Param("phone_number") String phone_number,
            @Param("address") Address address);
}