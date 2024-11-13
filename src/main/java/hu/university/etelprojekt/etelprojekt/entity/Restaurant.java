package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.*;
import java.io.Serializable;

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

    // Getters and Setters
    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPictureUrl() {
        return picture_url;
    }

    public void setPictureUrl(String pictureUrl) {
        this.picture_url = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDeliveryFee() { // Ensure getter matches field name
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) { // Ensure setter matches field name
        this.deliveryFee = deliveryFee;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}