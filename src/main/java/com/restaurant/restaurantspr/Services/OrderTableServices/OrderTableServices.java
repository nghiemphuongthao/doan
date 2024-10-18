package com.restaurant.restaurantspr.Services.OrderTableServices;

import com.restaurant.restaurantspr.Entities.OrderTable;
import com.restaurant.restaurantspr.Repositories.OrderTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderTableServices implements IOrderTableServices {

    private final OrderTableRepository orderTableRepository;

    @Autowired
    public OrderTableServices(OrderTableRepository orderTableRepository) {
        this.orderTableRepository = orderTableRepository;
    }

    @Override
    public List<OrderTable> getAllOrderTables() {
        return orderTableRepository.findAll();
    }

    @Override
    public Optional<OrderTable> getOrderTableById(Long id) {
        return orderTableRepository.findById(id);
    }

    @Override
    public OrderTable createOrderTable(OrderTable orderTable) {
        return orderTableRepository.save(orderTable);
    }

    @Override
    public OrderTable updateOrderTable(Long id, OrderTable updatedOrderTable) {
        if (orderTableRepository.existsById(id)) {
            updatedOrderTable.setId(id);
            return orderTableRepository.save(updatedOrderTable);
        }
        return null;  // or throw an exception
    }

    @Override
    public void deleteOrderTable(Long id) {
        orderTableRepository.deleteById(id);
    }
}

