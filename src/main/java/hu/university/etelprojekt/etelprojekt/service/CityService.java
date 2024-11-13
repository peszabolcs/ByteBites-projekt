package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.City;
import hu.university.etelprojekt.etelprojekt.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    // Get all cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Get city by ID
    public Optional<City> getCityById(Long cityId) {
        return cityRepository.findById(cityId);
    }

    // Get city by name
    public Optional<City> getCityByName(String cityName) {
        return Optional.ofNullable(cityRepository.findByCityName(cityName));
    }

    // Save or update a city
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    // Delete city by ID
    public void deleteCityById(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
