package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    Optional<Doctor> findByMail(String email);
    boolean existsByMail(String email);
}
