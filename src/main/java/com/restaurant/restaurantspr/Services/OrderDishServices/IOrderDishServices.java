package com.restaurant.restaurantspr.Services.OrderDishServices;

import com.restaurant.restaurantspr.Entities.OrderDish;

import java.util.List;
import java.util.Optional;

public interface IOrderDishServices {
    List<OrderDish> getAllOrderDishes();
    Optional<OrderDish> getOrderDishById(Long id);
    OrderDish createOrderDish(OrderDish orderDish);
    OrderDish updateOrderDish(Long id, OrderDish updatedOrderDish);
    void deleteOrderDish(Long id);
}
