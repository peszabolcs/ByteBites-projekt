package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "picture_url")
    private String picture_url;

    @Column(name = "description")
    private String description;

    @Column(name = "delivery_fee")
    private Double deliveryFee; // Changed to match the Java field name

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}