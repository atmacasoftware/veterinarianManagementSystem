package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.dto.request.doctor.DoctorForAvailableDateRequest;
import net.atmacacode.veterinarian.dto.request.doctor.DoctorRequest;
import net.atmacacode.veterinarian.entities.AvailableDate;
import net.atmacacode.veterinarian.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
    Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, long id);
}
