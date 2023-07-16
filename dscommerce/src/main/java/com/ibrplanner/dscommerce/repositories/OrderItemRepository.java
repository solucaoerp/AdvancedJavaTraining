package com.ibrplanner.dscommerce.repositories;

import com.ibrplanner.dscommerce.entities.OrderItem;
import com.ibrplanner.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
