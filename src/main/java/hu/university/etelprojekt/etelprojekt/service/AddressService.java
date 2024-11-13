package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Address;
import hu.university.etelprojekt.etelprojekt.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        return addressRepository.findById(id).map(address -> {
            address.setPostalCode(addressDetails.getPostalCode());
            address.setCity(addressDetails.getCity());
            address.setStreetName(addressDetails.getStreetName());
            address.setPublicPlaceName(addressDetails.getPublicPlaceName());
            address.setHouseNumber(addressDetails.getHouseNumber());
            address.setBuilding(addressDetails.getBuilding());
            address.setStaircase(addressDetails.getStaircase());
            address.setFloor(addressDetails.getFloor());
            address.setDoor(addressDetails.getDoor());
            return addressRepository.save(address);
        }).orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public List<Address> findByPostalCode(String postalCode) {
        return addressRepository.findByPostalCode(postalCode);
    }

    public List<Address> findByCity(String city) {
        return addressRepository.findByCity(city);
    }

    public List<Address> findByCityAndStreetName(String city, String streetName) {
        return addressRepository.findByCityAndStreetName(city, streetName);
    }
}
