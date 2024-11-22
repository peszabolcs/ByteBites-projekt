package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address") // Optional: specify the table name in the database
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the addressId (primary key)
    private Long address_id;

    @Setter
    @Getter
    private String postalCode;

    @Setter
    @Getter
    private String city;

    @Setter
    @Getter
    private String streetName;

    @Setter
    @Getter
    private String publicPlaceName;

    @Setter
    @Getter
    private String houseNumber;

    @Setter
    @Getter
    private String building;

    @Setter
    @Getter
    private String staircase;

    @Setter
    @Getter
    private String floor;

    @Setter
    @Getter
    private String door;

    @Override
    public String toString() {
        return "Address [addressId=" + address_id + ", postal_code=" + postalCode + ", city=" + city +
                ", streetName=" + streetName + ", publicPlaceName=" + publicPlaceName + ", houseNumber=" +
                houseNumber + ", building=" + building + ", staircase=" + staircase + ", floor=" + floor +
                ", door=" + door + "]";
    }
}
