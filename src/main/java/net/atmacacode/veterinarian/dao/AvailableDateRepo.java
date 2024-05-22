package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
    Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, long id);
    List<AvailableDate> findByDoctorIdAndAvailableDateBetween(Long doctorId, LocalDate from, LocalDate to);
}
