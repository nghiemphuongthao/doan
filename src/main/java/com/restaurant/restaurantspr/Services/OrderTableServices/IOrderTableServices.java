package com.restaurant.restaurantspr.Services.OrderTableServices;

import com.restaurant.restaurantspr.Entities.OrderTable;

import java.util.List;
import java.util.Optional;

public interface IOrderTableServices {
    List<OrderTable> getAllOrderTables();
    Optional<OrderTable> getOrderTableById(Long id);
    OrderTable createOrderTable(OrderTable orderTable);
    OrderTable updateOrderTable(Long id, OrderTable updatedOrderTable);
    void deleteOrderTable(Long id);
}

