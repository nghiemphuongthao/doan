package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.OrderTable;
import com.restaurant.restaurantspr.Services.OrderTableServices.IOrderTableServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-tables")
public class OrderTableController {

    private final IOrderTableServices orderTableServices;

    @Autowired
    public OrderTableController(IOrderTableServices orderTableServices) {
        this.orderTableServices = orderTableServices;
    }

    @GetMapping
    public List<OrderTable> getAllOrderTables() {
        return orderTableServices.getAllOrderTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderTable> getOrderTableById(@PathVariable Long id) {
        Optional<OrderTable> orderTable = orderTableServices.getOrderTableById(id);
        return orderTable.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderTable createOrderTable(@RequestBody OrderTable orderTable) {
        return orderTableServices.createOrderTable(orderTable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderTable> updateOrderTable(@PathVariable Long id, @RequestBody OrderTable updatedOrderTable) {
        OrderTable orderTable = orderTableServices.updateOrderTable(id, updatedOrderTable);
        return orderTable != null ? ResponseEntity.ok(orderTable) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderTable(@PathVariable Long id) {
        orderTableServices.deleteOrderTable(id);
        return ResponseEntity.noContent().build();
    }
}

