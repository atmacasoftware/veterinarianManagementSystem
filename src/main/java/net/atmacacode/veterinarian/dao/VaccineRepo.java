package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
}
