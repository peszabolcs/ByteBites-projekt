package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "registration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column(name = "user_type", nullable = false, length = 50)
    private String userType;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = true) // Allow null addresses
    private Address address;

    public User(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", status="
                + status
                + ", registrationDate=" + registrationDate + ", userType=" + userType + ", phoneNumber="
                + phoneNumber
                + ", email=" + email + ", address=" + address + "]";
    }
}
