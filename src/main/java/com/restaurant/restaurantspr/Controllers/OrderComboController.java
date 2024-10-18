package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.OrderCombo;
import com.restaurant.restaurantspr.Services.OrderComboServices.IOrderComboServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-combos")
public class OrderComboController {

    private final IOrderComboServices orderComboServices;

    @Autowired
    public OrderComboController(IOrderComboServices orderComboServices) {
        this.orderComboServices = orderComboServices;
    }

    @GetMapping
    public List<OrderCombo> getAllOrderCombos() {
        return orderComboServices.getAllOrderCombos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCombo> getOrderComboById(@PathVariable Long id) {
        Optional<OrderCombo> orderCombo = orderComboServices.getOrderComboById(id);
        return orderCombo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderCombo createOrderCombo(@RequestBody OrderCombo orderCombo) {
        return orderComboServices.createOrderCombo(orderCombo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderCombo> updateOrderCombo(@PathVariable Long id, @RequestBody OrderCombo updatedOrderCombo) {
        OrderCombo orderCombo = orderComboServices.updateOrderCombo(id, updatedOrderCombo);
        return orderCombo != null ? ResponseEntity.ok(orderCombo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderCombo(@PathVariable Long id) {
        orderComboServices.deleteOrderCombo(id);
        return ResponseEntity.noContent().build();
    }
}

