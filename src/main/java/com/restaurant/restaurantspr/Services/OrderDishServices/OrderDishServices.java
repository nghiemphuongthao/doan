package com.restaurant.restaurantspr.Services.OrderDishServices;

import com.restaurant.restaurantspr.Entities.OrderDish;
import com.restaurant.restaurantspr.Repositories.OrderDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDishServices implements IOrderDishServices {

    private final OrderDishRepository orderDishRepository;

    @Autowired
    public OrderDishServices(OrderDishRepository orderDishRepository) {
        this.orderDishRepository = orderDishRepository;
    }

    @Override
    public List<OrderDish> getAllOrderDishes() {
        return orderDishRepository.findAll();
    }

    @Override
    public Optional<OrderDish> getOrderDishById(Long id) {
        return orderDishRepository.findById(id);
    }

    @Override
    public OrderDish createOrderDish(OrderDish orderDish) {
        return orderDishRepository.save(orderDish);
    }

    @Override
    public OrderDish updateOrderDish(Long id, OrderDish updatedOrderDish) {
        if (orderDishRepository.existsById(id)) {
            updatedOrderDish.setId(id);
            return orderDishRepository.save(updatedOrderDish);
        }
        return null;  // or throw an exception
    }

    @Override
    public void deleteOrderDish(Long id) {
        orderDishRepository.deleteById(id);
    }
}

