package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal, Integer> {
}
