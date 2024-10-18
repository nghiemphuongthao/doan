package com.restaurant.restaurantspr.Repositories;

import com.restaurant.restaurantspr.Entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>, JpaSpecificationExecutor<Dish> {

    // Define method to find all dishes by name
    List<Dish> findAllByName(String name);

    // If you want to do a case-insensitive search
    List<Dish> findAllByNameIgnoreCase(String name);
}
