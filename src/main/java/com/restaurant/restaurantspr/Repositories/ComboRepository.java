package com.restaurant.restaurantspr.Repositories;

import com.restaurant.restaurantspr.Entities.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {
}
