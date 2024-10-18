package com.restaurant.restaurantspr.Services.ComboServices;

import com.restaurant.restaurantspr.Entities.Combo;
import com.restaurant.restaurantspr.Repositories.ComboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComboServices implements IComboServices {
    private final ComboRepository comboRepository;

    @Autowired
    public ComboServices(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    @Override
    public Combo createCombo(Combo combo) {
        return comboRepository.save(combo);
    }

    @Override
    public Combo getComboById(Long comboId) {
        return comboRepository.findById(comboId).orElse(null);
    }

    @Override
    public List<Combo> getAllCombos() {
        return comboRepository.findAll();
    }

    @Override
    public Combo updateCombo(Long comboId, Combo combo) {
        if (comboRepository.existsById(comboId)) {
            combo.setComboId(comboId);
            return comboRepository.save(combo);
        }
        return null;
    }

    @Override
    public void deleteCombo(Long comboId) {
        comboRepository.deleteById(comboId);
    }
}
