package com.restaurant.restaurantspr.Services.DishServices;

import com.restaurant.restaurantspr.Entities.Dish;

import java.util.List;
import java.util.Optional;

public interface IDishServices {
    Dish createDish(Dish dish);
    List<Dish> getAllDishes();
    Optional<Dish> getDishById(Long id);
    Dish updateDish(Long id, Dish updatedDish);
    void deleteDish(Long id);
    List<Dish> findDishesByName(String name);
}
