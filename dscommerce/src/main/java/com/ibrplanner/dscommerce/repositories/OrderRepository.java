package com.ibrplanner.dscommerce.repositories;

import com.ibrplanner.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
