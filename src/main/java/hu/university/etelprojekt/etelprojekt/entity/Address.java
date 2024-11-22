package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address") // Optional: specify the table name in the database
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the addressId (primary key)
    private Long address_id;
    private String postalCode;
    private String city;
    private String streetName;
    private String publicPlaceName;
    private String houseNumber;
    private String building;
    private String staircase;
    private String floor;
    private String door;
    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Restaurant> restaurants;

    //Lombok annotációk hasznosak! Ha már be van húzva használjátok! Többi entity-ben is!
    // Default constructor
//    public Address() {
//    }


    // Constructor with all fields
//    public Address(Long address_id, String postal_code, String city, String street_name,
//            String public_place_name, String house_number, String building,
//            String staircase, String floor, String door) {
//        this.address_id = address_id;
//        this.postalCode = postal_code;
//        this.city = city;
//        this.streetName = street_name;
//        this.public_place_name = public_place_name;
//        this.house_number = house_number;
//        this.building = building;
//        this.staircase = staircase;
//        this.floor = floor;
//        this.door = door;
//    }

    @Override
    public String toString() {
        return "Address [addressId=" + address_id + ", postal_code=" + postalCode + ", city=" + city +
                ", streetName=" + streetName + ", publicPlaceName=" + publicPlaceName + ", houseNumber=" +
                houseNumber + ", building=" + building + ", staircase=" + staircase + ", floor=" + floor +
                ", door=" + door + "]";
    }
}
