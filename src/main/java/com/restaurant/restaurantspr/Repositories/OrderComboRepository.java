package com.restaurant.restaurantspr.Repositories;

import com.restaurant.restaurantspr.Entities.OrderCombo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderComboRepository extends JpaRepository<OrderCombo, Long> {
}
