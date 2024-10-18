package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.RestaurantTable;
import com.restaurant.restaurantspr.Services.RestaurantTableServices.IRestaurantTableServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {

    private final IRestaurantTableServices restaurantTableServices;

    @Autowired
    public RestaurantTableController(IRestaurantTableServices restaurantTableServices) {
        this.restaurantTableServices = restaurantTableServices;
    }

    // Lấy tất cả bàn
    @GetMapping
    public List<RestaurantTable> getAllTables() {
        return restaurantTableServices.getAllTables();
    }

    // Tìm bàn theo ID
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTableById(@PathVariable Long id) {
        Optional<RestaurantTable> table = restaurantTableServices.getTableById(id);
        return table.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo bàn mới
    @PostMapping
    public ResponseEntity<RestaurantTable> createTable(@RequestBody RestaurantTable table) {
        RestaurantTable createdTable = restaurantTableServices.createTable(table);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTable);
    }

    // Cập nhật thông tin bàn
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTable> updateTable(@PathVariable Long id, @RequestBody RestaurantTable updatedTable) {
        RestaurantTable table = restaurantTableServices.updateTable(id, updatedTable);
        return table != null ? ResponseEntity.ok(table) : ResponseEntity.notFound().build();
    }

    // Xóa bàn
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        restaurantTableServices.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
