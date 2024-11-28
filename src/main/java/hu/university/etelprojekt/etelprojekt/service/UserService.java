package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Find a user by ID
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    // Find a user by email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Find a user by first and last name
    public Optional<User> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    // Find a user by user type
    public Optional<User> findByUserType(String userType) {
        return userRepository.findByUserType(userType);
    }

    // Find a user by phone number
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    // Find a user by city in the address
    public Optional<User> findByAddressCity(String city) {
        return userRepository.findByAddress_City(city);
    }

    // Get all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Create or update a user
    public User save(User user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        User user = userOptional.orElse(null);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }
}
