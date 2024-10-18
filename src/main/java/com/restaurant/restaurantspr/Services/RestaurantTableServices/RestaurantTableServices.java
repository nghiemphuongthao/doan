package com.restaurant.restaurantspr.Services.RestaurantTableServices;

import com.restaurant.restaurantspr.Entities.RestaurantTable;
import com.restaurant.restaurantspr.Repositories.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableServices implements IRestaurantTableServices{

    private final RestaurantTableRepository restaurantTableRepository;

    @Autowired
    public RestaurantTableServices(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    // Lấy tất cả bàn
    public List<RestaurantTable> getAllTables() {
        return restaurantTableRepository.findAll();
    }

    // Tìm bàn theo ID
    public Optional<RestaurantTable> getTableById(Long id) {
        return restaurantTableRepository.findById(id);
    }

    // Tạo bàn mới
    public RestaurantTable createTable(RestaurantTable table) {
        return restaurantTableRepository.save(table);
    }

    // Cập nhật thông tin bàn
    public RestaurantTable updateTable(Long id, RestaurantTable updatedTable) {
        // Kiểm tra xem bàn có tồn tại không
        if (restaurantTableRepository.existsById(id)) {
            updatedTable.setTableId(id);
            return restaurantTableRepository.save(updatedTable);
        }
        return null; // Hoặc ném ra một exception
    }

    // Xóa bàn
    public void deleteTable(Long id) {
        restaurantTableRepository.deleteById(id);
    }
}
