package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "address") // Optional: specify the table name in the database
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the addressId (primary key)
    private Long address_id;

    private String postalCode;
    private String city;
    private String streetName;
    private String public_place_name;
    private String house_number;
    private String building;
    private String staircase;
    private String floor;
    private String door;

    // Default constructor
    public Address() {
    }

    // Constructor with all fields
    public Address(Long address_id, String postal_code, String city, String street_name,
            String public_place_name, String house_number, String building,
            String staircase, String floor, String door) {
        this.address_id = address_id;
        this.postalCode = postal_code;
        this.city = city;
        this.streetName = street_name;
        this.public_place_name = public_place_name;
        this.house_number = house_number;
        this.building = building;
        this.staircase = staircase;
        this.floor = floor;
        this.door = door;
    }

    // Getters and Setters
    public Long getAddressId() {
        return address_id;
    }

    public void setAddressId(Long addressId) {
        this.address_id = addressId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPublicPlaceName() {
        return public_place_name;
    }

    public void setPublicPlaceName(String publicPlaceName) {
        this.public_place_name = publicPlaceName;
    }

    public String getHouseNumber() {
        return house_number;
    }

    public void setHouseNumber(String houseNumber) {
        this.house_number = houseNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStaircase() {
        return staircase;
    }

    public void setStaircase(String staircase) {
        this.staircase = staircase;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "Address [addressId=" + address_id + ", postal_code=" + postalCode + ", city=" + city +
                ", streetName=" + streetName + ", publicPlaceName=" + public_place_name + ", houseNumber=" +
                house_number + ", building=" + building + ", staircase=" + staircase + ", floor=" + floor +
                ", door=" + door + "]";
    }
}
