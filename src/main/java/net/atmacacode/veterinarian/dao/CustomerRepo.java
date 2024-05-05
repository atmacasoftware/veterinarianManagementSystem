package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
