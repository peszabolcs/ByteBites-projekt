package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Favourites;
import hu.university.etelprojekt.etelprojekt.entity.FavouritesId;
import hu.university.etelprojekt.etelprojekt.service.FavouritesService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourites")
public class FavouritesController {

    private final FavouritesService favouritesService;

    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    // Get favourites by user ID
    @GetMapping("/user/{userId}")
    public List<Favourites> getFavouritesByUserId(@PathVariable Long userId) {
        return favouritesService.getFavouritesByUserId(userId);
    }

    // Get favourites by restaurant ID
    @GetMapping("/restaurant/{restaurantId}")
    public List<Favourites> getFavouritesByRestaurantId(@PathVariable Long restaurantId) {
        return favouritesService.getFavouritesByRestaurantId(restaurantId);
    }

    // Get favourites by dish ID
    @GetMapping("/dish/{dishId}")
    public List<Favourites> getFavouritesByDishId(@PathVariable Long dishId) {
        return favouritesService.getFavouritesByDishId(dishId);
    }

    // Get favourites by favourite type
    @GetMapping("/type/{favType}")
    public List<Favourites> getFavouritesByFavType(@PathVariable String favType) {
        return favouritesService.getFavouritesByFavType(favType);
    }

    // Save a new favourite
    @PostMapping
    public Favourites addFavourite(@RequestBody Favourites favourite) {
        return favouritesService.saveFavourite(favourite);
    }

    // Delete a favourite by composite ID
    @DeleteMapping("/{userId}/{restaurantId}/{dishId}")
    public void deleteFavourite(
            @PathVariable Long userId,
            @PathVariable Long restaurantId,
            @PathVariable Long dishId) {
        FavouritesId id = new FavouritesId(userId, restaurantId, dishId);
        favouritesService.deleteFavourite(id);
    }
}