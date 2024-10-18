package com.restaurant.restaurantspr.Services.RestaurantTableServices;

import com.restaurant.restaurantspr.Entities.RestaurantTable;

import java.util.List;
import java.util.Optional;

public interface IRestaurantTableServices {
    List<RestaurantTable> getAllTables();

    Optional<RestaurantTable> getTableById(Long id);

    RestaurantTable createTable(RestaurantTable table);

    RestaurantTable updateTable(Long id, RestaurantTable updatedTable);

    void deleteTable(Long id);
}
