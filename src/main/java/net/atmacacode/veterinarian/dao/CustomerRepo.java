package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMail(String email);
    boolean existsByMail(String email);
    List<Customer> findByNameContainsIgnoreCase(String name);
}
