package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}
