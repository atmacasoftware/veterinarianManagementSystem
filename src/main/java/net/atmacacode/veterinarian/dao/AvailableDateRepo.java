package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
}
