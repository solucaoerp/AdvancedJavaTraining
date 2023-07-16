package com.ibrplanner.dscommerce.repositories;

import com.ibrplanner.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
