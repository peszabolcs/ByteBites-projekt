package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "addresses") // Optional: specify the table name in the database
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the addressId (primary key)
    private Long addressId;

    private String postalCode;
    private String city;
    private String streetName;
    private String publicPlaceName;
    private String houseNumber;
    private String building;
    private String staircase;
    private String floor;
    private String door;

    // Default constructor
    public Address() {
    }

    // Constructor with all fields
    public Address(Long addressId, String postalCode, String city, String streetName,
            String publicPlaceName, String houseNumber, String building,
            String staircase, String floor, String door) {
        this.addressId = addressId;
        this.postalCode = postalCode;
        this.city = city;
        this.streetName = streetName;
        this.publicPlaceName = publicPlaceName;
        this.houseNumber = houseNumber;
        this.building = building;
        this.staircase = staircase;
        this.floor = floor;
        this.door = door;
    }

    // Getters and Setters
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
        return publicPlaceName;
    }

    public void setPublicPlaceName(String publicPlaceName) {
        this.publicPlaceName = publicPlaceName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
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
        return "Address [addressId=" + addressId + ", postalCode=" + postalCode + ", city=" + city +
                ", streetName=" + streetName + ", publicPlaceName=" + publicPlaceName + ", houseNumber=" +
                houseNumber + ", building=" + building + ", staircase=" + staircase + ", floor=" + floor +
                ", door=" + door + "]";
    }
}
