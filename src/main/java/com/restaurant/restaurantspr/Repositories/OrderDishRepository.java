package com.restaurant.restaurantspr.Repositories;

import com.restaurant.restaurantspr.Entities.OrderDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDishRepository extends JpaRepository<OrderDish, Long> {
}
