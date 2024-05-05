package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepo extends JpaRepository<Vaccine, Integer> {
}
