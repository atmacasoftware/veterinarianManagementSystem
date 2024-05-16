package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMail(String email);
    boolean existsByMail(String email);
}
