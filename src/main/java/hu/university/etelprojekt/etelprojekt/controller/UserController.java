package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.entity.UserDTO;
import hu.university.etelprojekt.etelprojekt.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by first name and last name
    @GetMapping("/name/{firstName}/{lastName}")
    public ResponseEntity<User> getUserByName(@PathVariable String firstName, @PathVariable String lastName) {
        Optional<User> user = userService.findByFirstNameAndLastName(firstName, lastName);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by user type
    @GetMapping("/type/{userType}")
    public ResponseEntity<Optional<User>> getUsersByUserType(@PathVariable String userType) {
        Optional<User> users = userService.findByUserType(userType);
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    // Get user by phone number
    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<User> getUserByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<User> user = userService.findByPhoneNumber(phoneNumber);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by city in the address
    @GetMapping("/city/{city}")
    public ResponseEntity<Optional<User>> getUsersByCity(@PathVariable String city) {
        Optional<User> users = userService.findByAddressCity(city);
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    // Create or update a user
    @PostMapping
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // User Registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            // Call the service method to register the user
            userService.save(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(HttpServletRequest request, @RequestParam String email, @RequestParam String password) {
        try {
            User authenticatedUser = userService.authenticate(email, password);
            System.out.println("Bejelentkezett userId: " + authenticatedUser.getUserId());

            // Frissítjük a session-t a legfrissebb User objektummal
            HttpSession session = request.getSession();
            session.setAttribute("user", authenticatedUser);

            return ResponseEntity.ok("Bejelentkezés sikeres!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Hibás email vagy jelszó!");
        }
    }



    @GetMapping("/session")
    public ResponseEntity<UserDTO> getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return ResponseEntity.status(401).body(null);
        }
        User user = (User) session.getAttribute("user");
        UserDTO userDTO = new UserDTO(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return ResponseEntity.ok(userDTO);
    }





    @GetMapping("/current-user")
    public ResponseEntity<String> getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nincs bejelentkezve.");
        }
        User user = (User) session.getAttribute("user");
        return ResponseEntity.ok(user.getFirstName() + " " + user.getLastName());
    }
}