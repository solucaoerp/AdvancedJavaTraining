package com.ibrplanner.dscommerce.repositories;

import com.ibrplanner.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
