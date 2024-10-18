package com.restaurant.restaurantspr.Repositories;

import com.restaurant.restaurantspr.Entities.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable, Long> {
}
