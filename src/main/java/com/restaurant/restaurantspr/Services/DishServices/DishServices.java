package com.restaurant.restaurantspr.Services.DishServices;

import com.restaurant.restaurantspr.Entities.Dish;
import com.restaurant.restaurantspr.Repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServices implements IDishServices {

    private final DishRepository dishRepository;

    @Autowired
    public DishServices(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    // Create a new dish
    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    // Read all dishes
    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    // Read a dish by ID
    @Override
    public Optional<Dish> getDishById(Long id) {
        return dishRepository.findById(id);
    }

    // Update a dish
    @Override
    public Dish updateDish(Long id, Dish updatedDish) {
        if (dishRepository.existsById(id)) {
            updatedDish.setDishId(id);
            return dishRepository.save(updatedDish);
        }
        return null; // or throw an exception
    }

    // Delete a dish
    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    // Find dishes by name
    @Override
    public List<Dish> findDishesByName(String name) {
        return dishRepository.findAllByNameIgnoreCase(name);
    }
}
