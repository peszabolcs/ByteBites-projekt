package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Favourites;
import hu.university.etelprojekt.etelprojekt.entity.FavouritesId;
import hu.university.etelprojekt.etelprojekt.repository.FavouritesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouritesService {

    private final FavouritesRepository favouritesRepository;

    public FavouritesService(FavouritesRepository favouritesRepository) {
        this.favouritesRepository = favouritesRepository;
    }

    // Find all favourites by userId
    public List<Favourites> getFavouritesByUserId(Long userId) {
        return favouritesRepository.findByUser_UserId(userId);
    }

    // Find all favourites by restaurantId
    public List<Favourites> getFavouritesByRestaurantId(Long restaurantId) {
        return favouritesRepository.findByRestaurant_RestaurantId(restaurantId);
    }

    // Find all favourites by dishId
    public List<Favourites> getFavouritesByDishId(Long dishId) {
        return favouritesRepository.findByDish_DishId(dishId);
    }

    // Find all favourites by favourite type
    public List<Favourites> getFavouritesByFavType(String favType) {
        return favouritesRepository.findByFavType(favType);
    }

    // Save or update a favourite
    public Favourites saveFavourite(Favourites favourite) {
        return favouritesRepository.save(favourite);
    }

    // Delete a favourite by composite ID
    public void deleteFavourite(FavouritesId id) {
        favouritesRepository.deleteById(id);
    }
}
