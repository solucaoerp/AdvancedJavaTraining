package com.ibrplanner.customers.repositories;

import com.ibrplanner.customers.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
