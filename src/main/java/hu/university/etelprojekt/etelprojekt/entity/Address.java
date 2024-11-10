package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "public_place_name")
    private String publicPlaceName;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "building")
    private String building;

    @Column(name = "staircase")
    private String staircase;

    @Column(name = "floor")
    private String floor;

    @Column(name = "door")
    private String door;

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
}
