package com.restaurant.restaurantspr.Repositories;

import com.restaurant.restaurantspr.Entities.ComboDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComboDishRepository extends JpaRepository<ComboDish, Long> {
    List<ComboDish> findByCombo_ComboId(Long comboId);
    List<ComboDish> findByDish_DishId(Long dishId);
}
