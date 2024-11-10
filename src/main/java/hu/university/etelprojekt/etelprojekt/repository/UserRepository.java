package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.UserType;

import java.util.List;
import java.util.Optional;

//import org.hibernate.usertype.UserType;
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
    @SuppressWarnings("unchecked")
    User save(User user);

    // Find a user by email (useful for login, etc.)
    Optional<User> findByEmail(String email);

    // Find a user by email and user type (e.g., to check if an admin exists with a
    // given email)
    Optional<User> findByEmailAndUserType(String email, UserType userType);

    // Find users by user type (e.g., to list all admins)
    List<User> findByUserType(UserType userType);

    // Find users by user type as a String (optional, if not using enum)
    List<User> findByUserType(String userType);

    // Find a user by their ID
    Optional<User> findById(Long userId);

    // Delete a user by their ID
    void deleteById(Long userId);

    // Update user status (example of custom query method)
    @Modifying
    @Query("UPDATE User u SET u.status = :status WHERE u.userId = :userId")
    void updateUserStatus(@Param("userId") Long userId, @Param("status") String status);

    // Update user information (name, phone, address, etc.)
    @Modifying
    @Query("UPDATE User u SET u.firstName = :firstName, u.lastName = :lastName, u.phoneNumber = :phoneNumber, u.address = :address WHERE u.userId = :userId")
    void updateUserInfo(@Param("userId") Long userId,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("phoneNumber") String phoneNumber,
            @Param("address") Address address);

    // Custom method to check if a user is an admin by email
    default boolean isAdmin(String email) {
        Optional<User> user = findByEmail(email);
        return user.isPresent() && user.get().getUserType() == UserType.ADMIN;
    }

    // Custom method to check if a user is an admin by ID
    default boolean isAdmin(Long userId) {
        Optional<User> user = findById(userId);
        return user.isPresent() && user.get().getUserType() == UserType.ADMIN;
    }
}