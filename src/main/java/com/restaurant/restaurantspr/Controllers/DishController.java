package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.Dish;
import com.restaurant.restaurantspr.Services.DishServices.IDishServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final IDishServices dishService;

    @Autowired
    public DishController(IDishServices dishService) {
        this.dishService = dishService;
    }

    // Get all dishes by name
    @GetMapping("/search")
    public ResponseEntity<List<Dish>> getDishesByName(@RequestParam String name) {
        List<Dish> dishes = dishService.findDishesByName(name);
        return ResponseEntity.ok(dishes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
        Optional<Dish> dish = dishService.getDishById(id);
        if (dish.isPresent()) {
            return ResponseEntity.ok(dish.get());
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }
    // Update a dish
    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish updatedDish) {
        Dish dish = dishService.updateDish(id, updatedDish);
        if (dish != null) {
            return ResponseEntity.ok(dish);
        }
        return ResponseEntity.notFound().build(); // Return 404 if dish not found
    }
}
