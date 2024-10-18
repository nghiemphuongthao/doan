package com.restaurant.restaurantspr.Services.ComboDishServices;

import com.restaurant.restaurantspr.Entities.ComboDish;
import com.restaurant.restaurantspr.Repositories.ComboDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComboDishServices implements IComboDishServices {
    private final ComboDishRepository comboDishRepository;

    @Autowired
    public ComboDishServices(ComboDishRepository comboDishRepository) {
        this.comboDishRepository = comboDishRepository;
    }

    @Override
    public List<ComboDish> getAllComboDishes() {
        return comboDishRepository.findAll();
    }

    @Override
    public Optional<ComboDish> getComboDishById(Long id) {
        return comboDishRepository.findById(id);
    }

    @Override
    public ComboDish createComboDish(ComboDish comboDish) {
        return comboDishRepository.save(comboDish);
    }

    @Override
    public ComboDish updateComboDish(Long id, ComboDish updatedComboDish) {
        if (comboDishRepository.existsById(id)) {
            updatedComboDish.setComboDishId(id);
            return comboDishRepository.save(updatedComboDish);
        }
        return null; // Hoặc ném ra một exception
    }

    @Override
    public void deleteComboDish(Long id) {
        comboDishRepository.deleteById(id);
    }

    @Override
    public List<ComboDish> getComboDishesByComboId(Long comboId) {
        return comboDishRepository.findByCombo_ComboId(comboId);
    }

    @Override
    public List<ComboDish> getComboDishesByDishId(Long dishId) {
        return comboDishRepository.findByDish_DishId(dishId);
    }
}
