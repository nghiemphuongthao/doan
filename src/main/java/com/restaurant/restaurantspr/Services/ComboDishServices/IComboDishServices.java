package com.restaurant.restaurantspr.Services.ComboDishServices;

import com.restaurant.restaurantspr.Entities.ComboDish;

import java.util.List;
import java.util.Optional;

public interface IComboDishServices {
    List<ComboDish> getAllComboDishes();
    Optional<ComboDish> getComboDishById(Long id);
    ComboDish createComboDish(ComboDish comboDish);
    ComboDish updateComboDish(Long id, ComboDish updatedComboDish);
    void deleteComboDish(Long id);
    List<ComboDish> getComboDishesByComboId(Long comboId);
    List<ComboDish> getComboDishesByDishId(Long dishId);
}
