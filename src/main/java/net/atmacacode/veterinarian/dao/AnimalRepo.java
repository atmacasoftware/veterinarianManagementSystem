package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
    Optional<Animal> findByNameAndCustomerId(String name, long id);
    List<Animal> findByNameContainsIgnoreCase(String name);
}
