package com.ibrplanner.dscommerce.services;

import com.ibrplanner.dscommerce.dtos.OrderDTO;
import com.ibrplanner.dscommerce.entities.Order;
import com.ibrplanner.dscommerce.repositories.OrderRepository;
import com.ibrplanner.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {

        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        return new OrderDTO(order);
    }
}
