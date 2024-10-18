package com.restaurant.restaurantspr.Services.OrderComboServices;

import com.restaurant.restaurantspr.Entities.OrderCombo;
import com.restaurant.restaurantspr.Repositories.OrderComboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderComboServices implements IOrderComboServices {

    private final OrderComboRepository orderComboRepository;

    @Autowired
    public OrderComboServices(OrderComboRepository orderComboRepository) {
        this.orderComboRepository = orderComboRepository;
    }

    @Override
    public List<OrderCombo> getAllOrderCombos() {
        return orderComboRepository.findAll();
    }

    @Override
    public Optional<OrderCombo> getOrderComboById(Long id) {
        return orderComboRepository.findById(id);
    }

    @Override
    public OrderCombo createOrderCombo(OrderCombo orderCombo) {
        return orderComboRepository.save(orderCombo);
    }

    @Override
    public OrderCombo updateOrderCombo(Long id, OrderCombo updatedOrderCombo) {
        if (orderComboRepository.existsById(id)) {
            updatedOrderCombo.setId(id);
            return orderComboRepository.save(updatedOrderCombo);
        }
        return null;  // or throw an exception
    }

    @Override
    public void deleteOrderCombo(Long id) {
        orderComboRepository.deleteById(id);
    }
}

