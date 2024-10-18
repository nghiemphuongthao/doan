package com.restaurant.restaurantspr.Services.OrderComboServices;

import com.restaurant.restaurantspr.Entities.OrderCombo;

import java.util.List;
import java.util.Optional;

public interface IOrderComboServices {
    List<OrderCombo> getAllOrderCombos();
    Optional<OrderCombo> getOrderComboById(Long id);
    OrderCombo createOrderCombo(OrderCombo orderCombo);
    OrderCombo updateOrderCombo(Long id, OrderCombo updatedOrderCombo);
    void deleteOrderCombo(Long id);
}
