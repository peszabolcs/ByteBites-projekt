package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users") // Specify the table name for the User entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String username;

    private String userType; // Store the userType as a String directly
    private String email;

    // Default constructor
    public User() {
    }

    // Constructor with all fields
    public User(Long user_id, String username, String email, String userType) {
        this.id = user_id;
        this.username = username;
        this.userType = userType;
        this.email = email;
    }

    // Getters and Setters
    public Long getUserId() {
        return id;
    }

    public void setUserId(Long user_id) {
        this.id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email; // Getter for email
    }

    public void setEmail(String email) {
        this.email = email; // Setter for email
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User [userId=" + id + ", username=" + username + ", email=" + email + ", userType=" + userType
                + "]";
    }
}
