package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.OrderDish;
import com.restaurant.restaurantspr.Services.OrderDishServices.IOrderDishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-dishes")
public class OrderDishController {

    private final IOrderDishServices orderDishServices;

    @Autowired
    public OrderDishController(IOrderDishServices orderDishServices) {
        this.orderDishServices = orderDishServices;
    }

    @GetMapping
    public List<OrderDish> getAllOrderDishes() {
        return orderDishServices.getAllOrderDishes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDish> getOrderDishById(@PathVariable Long id) {
        Optional<OrderDish> orderDish = orderDishServices.getOrderDishById(id);
        return orderDish.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderDish createOrderDish(@RequestBody OrderDish orderDish) {
        return orderDishServices.createOrderDish(orderDish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDish> updateOrderDish(@PathVariable Long id, @RequestBody OrderDish updatedOrderDish) {
        OrderDish orderDish = orderDishServices.updateOrderDish(id, updatedOrderDish);
        return orderDish != null ? ResponseEntity.ok(orderDish) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDish(@PathVariable Long id) {
        orderDishServices.deleteOrderDish(id);
        return ResponseEntity.noContent().build();
    }
}

