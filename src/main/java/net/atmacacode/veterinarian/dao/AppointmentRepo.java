package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppoinmentDate(Long id, LocalDateTime localDateTime);
    Optional<Appointment> findByCustomerIdAndAnimalIdAndAppoinmentDate(Long customerId, Long animalId, LocalDateTime localDateTime);
    List<Appointment> findByAnimalIdAndAppoinmentDateBetween(Long animalId, LocalDateTime start, LocalDateTime end);
}
