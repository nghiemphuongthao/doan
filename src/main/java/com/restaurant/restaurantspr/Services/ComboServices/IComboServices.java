package com.restaurant.restaurantspr.Services.ComboServices;

import com.restaurant.restaurantspr.Entities.Combo;

import java.util.List;

public interface IComboServices {
    Combo createCombo(Combo combo);
    Combo getComboById(Long comboId);
    List<Combo> getAllCombos();
    Combo updateCombo(Long comboId, Combo combo);
    void deleteCombo(Long comboId);
}
